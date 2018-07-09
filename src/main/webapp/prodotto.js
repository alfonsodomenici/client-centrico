/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Tabella from './Tabella.js';

let tb = new Tabella("ciao");
tb.stampa();


let btn = document.querySelector('#btnInvia');

btn.onclick = function (e) {
    e.preventDefault();

    let data = {
        codice: document.getElementsByName("cod")[0].value,
        descrizione: document.getElementsByName("descr")[0].value,
        prezzo: document.getElementsByName("prezzo")[0].value
    };
    fetch('http://localhost:8080/client-centrico/resources/prodotti', {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    }).then(r => console.log(r));

};