import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { FullName } from 'src/app/domain/fullname';
import { FullNameService } from 'src/app/services/fullname.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  public currentName: Observable<FullName> | undefined;

  constructor(private fullNameservice: FullNameService) {}

  ngOnInit(): void {
    this.currentName = this.fullNameservice.getLast();
  }

  public onGenerateNewNamePressed() {
    console.log('onGenerateNewNamePressed');
    this.currentName = this.fullNameservice.generate();
    this.currentName.subscribe(
      () => {},
      (err) => {
        alert('no data to generate');
      }
    );
  }
}
