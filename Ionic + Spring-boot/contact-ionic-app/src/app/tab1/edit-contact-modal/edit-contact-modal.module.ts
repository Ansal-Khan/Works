import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { EditContactModalPage } from './edit-contact-modal.page';

const routes: Routes = [
  {
    path: '/edit',
    component: EditContactModalPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [EditContactModalPage]
})
export class EditContactModalPageModule {}
