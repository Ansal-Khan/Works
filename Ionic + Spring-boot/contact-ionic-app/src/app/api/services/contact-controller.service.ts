/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { Contact } from '../models/contact';

/**
 * Contact Controller
 */
@Injectable({
  providedIn: 'root',
})
class ContactControllerService extends __BaseService {
  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * @param id id
   */
  deleteContactUsingDELETEResponse(id: number): __Observable<__StrictHttpResponse<null>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'DELETE',
      this.rootUrl + `/api/delete/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<null>;
      })
    );
  }
  /**
   * @param id id
   */
  deleteContactUsingDELETE(id: number): __Observable<null> {
    return this.deleteContactUsingDELETEResponse(id).pipe(
      __map(_r => _r.body as null)
    );
  }

  /**
   * @return OK
   */
  readAllContactsUsingGETResponse(): __Observable<__StrictHttpResponse<Array<Contact>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/get`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<Contact>>;
      })
    );
  }
  /**
   * @return OK
   */
  readAllContactsUsingGET(): __Observable<Array<Contact>> {
    return this.readAllContactsUsingGETResponse().pipe(
      __map(_r => _r.body as Array<Contact>)
    );
  }

  /**
   * @param id id
   * @return OK
   */
  readContactUsingGETResponse(id: number): __Observable<__StrictHttpResponse<Contact>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/api/get/${id}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Contact>;
      })
    );
  }
  /**
   * @param id id
   * @return OK
   */
  readContactUsingGET(id: number): __Observable<Contact> {
    return this.readContactUsingGETResponse(id).pipe(
      __map(_r => _r.body as Contact)
    );
  }

  /**
   * @param contact contact
   * @return OK
   */
  createContactUsingPOSTResponse(contact: Contact): __Observable<__StrictHttpResponse<Contact>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = contact;
    let req = new HttpRequest<any>(
      'POST',
      this.rootUrl + `/api/new`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Contact>;
      })
    );
  }
  /**
   * @param contact contact
   * @return OK
   */
  createContactUsingPOST(contact: Contact): __Observable<Contact> {
    return this.createContactUsingPOSTResponse(contact).pipe(
      __map(_r => _r.body as Contact)
    );
  }

  /**
   * @param contact contact
   * @return OK
   */
  updateContactUsingPUTResponse(contact: Contact): __Observable<__StrictHttpResponse<Contact>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    __body = contact;
    let req = new HttpRequest<any>(
      'PUT',
      this.rootUrl + `/api/update`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Contact>;
      })
    );
  }
  /**
   * @param contact contact
   * @return OK
   */
  updateContactUsingPUT(contact: Contact): __Observable<Contact> {
    return this.updateContactUsingPUTResponse(contact).pipe(
      __map(_r => _r.body as Contact)
    );
  }
}

module ContactControllerService {
}

export { ContactControllerService }
