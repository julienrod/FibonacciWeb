import { Component, OnInit } from '@angular/core';
import { Observable, Subject, of } from 'rxjs';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  fibonacci$: Observable<string[]>;
  private searchTerms = new Subject<string>();
  private serverUrl = 'http://localhost:8091/api/api/fibonacci';
  
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }
  
  // Push a search term into the observable stream.
  search(maxValue: string): void {
	  if(maxValue === ''){
		  this.fibonacci$ = of([]);
		  return;
	  }
	  this.http.post<string[]>(this.serverUrl, maxValue, this.httpOptions).subscribe(response => this.fibonacci$ = of(response));
  }

  ngOnInit(): void {}
}
