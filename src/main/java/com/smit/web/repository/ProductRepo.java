package com.smit.web.repository;

import com.smit.web.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Products p) {
        String sql = "insert into products (pid, pname, pprice) values(?,?,?)";
        int rows = jdbc.update(sql, p.getPid(), p.getPname(), p.getPprice());
        System.out.println(rows + " effected");
//        System.out.println("Product Added");
    }

//Rowmapper//

    public List<Products> findAll() {
        String sql = "select * from Products";
        RowMapper<Products> mapper = new RowMapper<Products>() {
            @Override
            public Products mapRow(ResultSet rs, int column) throws SQLException {
                Products p = new Products();
                p.setPid(rs.getInt("pid"));
                p.setPname(rs.getString("pname"));
                p.setPprice(rs.getInt("pprice"));
                return p;
            }
        };
        return jdbc.query(sql, mapper);


//public List<Products> findAll(){
//List<Products> products = new ArrayList<>();
//return products;
//}
    }
}