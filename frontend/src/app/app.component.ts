import { Component } from '@angular/core';
import { FullNameService } from './services/fullname.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'frontend';

  constructor(private fullNameservice: FullNameService) {}

  ngOnInit(): void {
    this.fullNameservice.getLast().subscribe((response) => {
      console.log(JSON.stringify(response));
    });
  }
}
