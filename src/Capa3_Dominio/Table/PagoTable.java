/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa3_Dominio.Table;

import Capa3_Dominio.Entidades.Pago;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

/**
 *
 * @author user
 */
public class PagoTable extends RecursiveTreeObject<PagoTable>{
    
    private Pago pago;

    public PagoTable() {
    }

    public PagoTable(Pago pago) {
        this.pago = pago;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
    
}
