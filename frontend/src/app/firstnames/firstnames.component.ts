import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { FirstName } from '../domain/firstname';
import { FirstNameService } from '../services/firstname.service';

@Component({
  selector: 'app-firstnames',
  templateUrl: './firstnames.component.html',
  styleUrls: ['./firstnames.component.scss'],
})
export class FirstnamesComponent implements OnInit {
  public list: Observable<FirstName[]> | undefined;

  public insertForm = new FormGroup({
    firstName: new FormControl(),
  });

  constructor(private firstNameservice: FirstNameService) {}

  ngOnInit(): void {
    this.list = this.firstNameservice.getlist();
  }

  public onCreatePressed() {}

  public onSubmitForm() {
    console.log('Submiting');
    this.firstNameservice.insert(this.insertForm.value).subscribe(() => {
      this.list = this.firstNameservice.getlist();
    });
  }

  public onDeleteRowPressed(index: number) {
    console.log('Deleting');
    this.firstNameservice.delete(index).subscribe(() => {
      this.list = this.firstNameservice.getlist();
    });
  }
}
