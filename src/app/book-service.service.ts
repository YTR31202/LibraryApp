import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from './book.model'; 
 
const baseUrl = "http://localhost:8083/api/v1";

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {

  constructor( private http:HttpClient) { }

  getAll(): Observable<Book[]>{
    return this.http.get<Book[]>(baseUrl);
  }
  create(data:any):Observable<any>{
    return this.http.post(baseUrl ,data);
  }
  get(id:any):Observable<Book>
  {
    return this.http.get<Book>(`${baseUrl}/${id}`);
  }
  update(id:any, data: any):Observable<Book>
  {
    return this.http.put<Book>(`${baseUrl}/${id}`,data);
  }
  delete(id:any):Observable<Book>
  {
    return this.http.delete<Book>(`${baseUrl}/${id}`);
  }
  findname(name:any):Observable<Book[]>{
    return this.http.get<Book[]>(`${baseUrl}?title=${name}`)
  }

}
