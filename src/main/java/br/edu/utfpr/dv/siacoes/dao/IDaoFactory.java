package br.edu.utfpr.dv.siacoes.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDaoFactory<T> {
    public List<T> listAll() throws SQLException;
    public T findById(int id) throws SQLException;
    public int save(int idUser, T type) throws SQLException;
}