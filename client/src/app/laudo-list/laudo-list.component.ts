import { Component, OnInit } from '@angular/core';
import { AdubacaoService } from '../shared/adubacao/adubacao.service';

@Component({
  selector: 'app-laudo-list',
  templateUrl: './laudo-list.component.html',
  styleUrls: ['./laudo-list.component.css']
})
export class LaudoListComponent implements OnInit {
  laudos: Array<any>;

  constructor(private adubacaoService: AdubacaoService) { }

  ngOnInit() {
    this.adubacaoService.getAll().subscribe(data => {
      this.laudos = data;
    });
  }

}
