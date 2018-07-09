/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


class Message extends HTMLElement{
    
    constructor(){
        super();
    }
    
    connectedCallback(){
        let el = document.createElement('h1');
        el.innerText = "Buon weekend...";
        this.appendChild(el);
    }
}

customElements.define('di-message',Message);