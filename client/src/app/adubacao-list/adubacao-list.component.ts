import { Component, OnInit } from '@angular/core';
import { AdubacaoService } from '../shared/adubacao/adubacao.service';
import { MatTableDataSource } from '@angular/material';
import { Diagnostico } from '../shared/adubacao/adubacao.model';
import { Router } from '@angular/router';
@Component({
  selector: 'app-adubacao-list',
  templateUrl: './adubacao-list.component.html',
  styleUrls: ['./adubacao-list.component.css']
})
export class AdubacaoListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nome', 'responsavel', 'open', 'edit', 'delete'];
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
    this.router.navigate(['/adubacao-add']);
  }

  edit(diagnostico: Diagnostico) {
    this.selected = diagnostico;
    this.router.navigate(['/adubacao-edit', this.selected.id]);
  }

  open(diagnostico: Diagnostico) {
    this.selected = diagnostico;
    this.router.navigate(['/adubacao-detail', this.selected.id]);
  }

  async delete(adubacao: Diagnostico) {
    if (confirm(`Tem certeza que deseja excluir o Laudo ${adubacao.laudo.nome}?`)) {
      this.adubacaoService.delete(adubacao.id);
    }
    await this.refresh();
  }

}
