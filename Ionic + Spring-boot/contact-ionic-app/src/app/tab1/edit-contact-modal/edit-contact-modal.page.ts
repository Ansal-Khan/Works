import { ModalController } from '@ionic/angular';
import { Component, Input } from '@angular/core';
import { Contact } from 'src/app/api/models';
import { ContactControllerService } from 'src/app/api/services';

@Component({
  selector: 'app-edit-contact-modal',
  templateUrl: './edit-contact-modal.page.html',
  styleUrls: ['./edit-contact-modal.page.scss'],
})
export class EditContactModalPage {

  @Input()contact: Contact;
  constructor(private modalController: ModalController, private apiService: ContactControllerService) { }

  closeModal() {
    this.modalController.dismiss();
  }

  updateContact() {
    this.apiService.updateContactUsingPUT(this.contact).subscribe(
      result => {
        this.contact = result;
        this.closeModal();
      },
      error => {
        console.log('Error Updating contact' + error);
      }
    )
  }
}
