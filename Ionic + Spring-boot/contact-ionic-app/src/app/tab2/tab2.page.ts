import { GlobalService } from './../global.service';
import { Contact } from './../api/models/contact';

import { ContactControllerService } from 'src/app/api/services';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page implements OnInit {

  contact: Contact;
  constructor(private apiService: ContactControllerService, private global: GlobalService) {
  }

  ngOnInit() {
    this.contact = new Contact(null, null, null);
  }

  createContact() {
    this.apiService.createContactUsingPOST(this.contact).subscribe(
      result => {
        this.contact = result;
        this.global.contacts.push(result);
      },
      error => {
        console.log('Error creating contact');
      }
    )
  }
}
