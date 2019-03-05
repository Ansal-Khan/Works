import { ContactControllerService } from 'src/app/api/services';
import { Contact } from 'src/app/api/models';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {
  public contacts: Contact[];
  constructor() { }
}
