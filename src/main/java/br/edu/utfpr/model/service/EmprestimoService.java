/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Emprestimo;
import br.edu.utfpr.model.Genero;
import br.edu.utfpr.model.dao.EmprestimoDAO;

/**
 *
 * @author Lucas
 */
public class EmprestimoService extends AbstractService<Long, Emprestimo> 
{
     public EmprestimoService()
    {
        dao = new EmprestimoDAO();
    }
    
}
