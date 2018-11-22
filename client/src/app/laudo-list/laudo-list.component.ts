import { Component, OnInit } from '@angular/core';
import { AdubacaoService } from '../shared/adubacao/adubacao.service';
import { MatTableDataSource } from '@angular/material';
import { Diagnostico } from '../shared/adubacao/adubacao.model';
import { Router } from '@angular/router';
@Component({
  selector: 'app-laudo-list',
  templateUrl: './laudo-list.component.html',
  styleUrls: ['./laudo-list.component.css']
})
export class LaudoListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nome', 'responsavel', 'edit', 'delete'];
  dataSource = new MatTableDataSource<any>();
  selected: Diagnostico = new Diagnostico();
  loading = false;

  constructor(private adubacaoService: AdubacaoService, private router: Router) { }

  ngOnInit() {
    this.refresh();
  }

  async refresh() {
    this.loading = true;
    this.adubacaoService.getAll().subscribe(data => {
      this.dataSource.data = data;
      console.log(this.dataSource.data);
    });
    this.loading = false;
  }

  create() {
    this.router.navigate(['/laudo-add']);
  }

  edit(diagnostico: Diagnostico) {
    this.selected = diagnostico;
    this.router.navigate(['/laudo-edit', this.selected.id]);
  }

  async delete(diagnostico: Diagnostico) {
    this.loading = true;
    if (confirm(`Tem certeza que deseja excluir o laudo ${diagnostico.laudo.nome}?`)) {
      this.adubacaoService.delete(diagnostico.id);
    }
    await this.refresh();
  }

}
