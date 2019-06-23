import { GlobalService } from './../global.service';
import { Contact } from './../api/models/contact';
import { EditContactModalPage } from './edit-contact-modal/edit-contact-modal.page';
import { Component, OnInit } from '@angular/core';
import { ModalController, AlertController } from '@ionic/angular';
import { ContactControllerService } from '../api/services';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page implements OnInit {
  constructor(private modalController: ModalController,
              private alertController: AlertController,
              private apiService: ContactControllerService,
              private global: GlobalService) {}

  contacts: Contact[];

  ngOnInit() {
    this.apiService.readAllContactsUsingGET().subscribe(
      result => {
        this.global.contacts = result;
        this.contacts = this.global.contacts;
      },
      error => {
        console.log('Error getting contact details');
      }
    );
  }

  async openModal(contact: Contact) {
    const modal = await this.modalController.create({
      component: EditContactModalPage,
      componentProps: {contact: contact},
      backdropDismiss: true,
      showBackdrop: true
    });
    return await modal.present();
  }

  async alertDelete(contact: Contact) {
    const alert = await this.alertController.create({
      header: 'Are you sure?',
      message: 'This contact will  be deleted!, <strong>Continue?</strong>',
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          cssClass: 'secondary'
        }, {
          text: 'Okay',
          handler: () => {
            this.deleteContact(contact);
          }
        }
      ],
      translucent: true
    });

    await alert.present();
  }

  deleteContact(contact:  Contact) {
    this.apiService.deleteContactUsingDELETE(contact.id).subscribe(
      result => {
        const index = this.contacts.indexOf(contact);
        this.contacts.splice(index, 1);
      },
      error => {
        console.log('Error deleteing Contact ' + error);
      }
    );
  }
}
