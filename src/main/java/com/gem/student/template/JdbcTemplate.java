package com.gem.student.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gem.student.template.interf.SQLExecutor;
import com.gem.student.template.interf.SqlQuerier;
import com.gem.student.template.interf.SqlUpdater;
import com.gem.student.utils.SimpleDataSource;


public class JdbcTemplate<T> {

    public final void simplteUpdate(SQLExecutor se) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = SimpleDataSource.getInstance().getConnection();
            pst = se.execute(conn);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pst != null) {
                	pst.close();
                }
                if(conn != null) {
                	conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public final void update(SqlUpdater su) {
        Connection conn = null;
        try {
            conn = SimpleDataSource.getInstance().getConnection();
            conn.setAutoCommit(false);
            su.execute(conn);
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public final T query(SqlQuerier<T> se) {
        Connection conn = null;
        T t = null;
        try {
            conn = SimpleDataSource.getInstance().getConnection();
            conn.setAutoCommit(false);
            t = se.execute(conn);
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return t;
    }
}