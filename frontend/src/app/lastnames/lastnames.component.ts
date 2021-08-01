import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { LastName } from '../domain/lastname';
import { LastNameService } from '../services/lastname.service';

@Component({
  selector: 'app-lastnames',
  templateUrl: './lastnames.component.html',
  styleUrls: ['./lastnames.component.scss'],
})
export class LastnamesComponent implements OnInit {
  public list: Observable<LastName[]> | undefined;

  public insertForm = new FormGroup({
    lastName: new FormControl(),
  });

  constructor(private lastNameservice: LastNameService) {}

  ngOnInit(): void {
    this.list = this.lastNameservice.getlist();
  }

  public onCreatePressed() {}

  public onSubmitForm() {
    console.log('Submiting');
    this.lastNameservice.insert(this.insertForm.value).subscribe(() => {
      this.list = this.lastNameservice.getlist();
    });
  }

  public onDeleteRowPressed(index: number) {
    console.log('Deleting');
    this.lastNameservice.delete(index).subscribe(() => {
      this.list = this.lastNameservice.getlist();
    });
  }
}
