/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


export default class Tabella{
    constructor(msg){
        this.msgValue = msg;
    }
    
    stampa(){
       console.log(this.msgValue); 
    }
}