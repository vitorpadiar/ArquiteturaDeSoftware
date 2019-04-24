package br.edu.utfpr.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import br.edu.utfpr.dto.PaisDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.java.Log;

@Log
public class PaisDAO extends Template {


    public PaisDAO() {
        try ( Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) {


            conn.createStatement().executeUpdate(
                    "CREATE TABLE pais ("
                    + "id int NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT id_pais_pk PRIMARY KEY,"
                    + "nome varchar(255),"
                    + "sigla varchar(3),"
                    + "codigoTelefone int)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean inserir(PaisDTO pais) {
        Template t = new PaisDAO();
        if(t.inserir(pais))
            return true;
        else return false;
    }

    public List<PaisDTO> listar() {
        Template t = new PaisDAO();

        return t.listar();
    }

    public boolean deletar(PaisDTO pais) {
        Template t = new PaisDAO();

        if(t.deletar(pais))
            return true;
        else return false;
    }

    public boolean alterar(PaisDTO pais) {
        Template t = new PaisDAO();

        if(t.alterar(pais))
            return true;
        else return false;
    }
}
