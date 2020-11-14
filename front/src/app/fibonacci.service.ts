import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FibonacciService  {
  private serverUrl = 'http://localhost:8091/api/api/fibonacci';
  
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  
  constructor(private http: HttpClient) { }
  
  /** POST fibonacci */
  askForFibonacci(maxValue: string): Observable<string[]> {
    return this.http.post<string[]>(this.serverUrl, maxValue, this.httpOptions).subscribe(response => console.log(response));
  }
  
}