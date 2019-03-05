/* tslint:disable */
export class Contact {
  firstName?: String;
  id?: number;
  lastName?: String;
  phoneNumber?: number;

  constructor(firstName: String, lastName: String, phoneNumber: number) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
  }
}
