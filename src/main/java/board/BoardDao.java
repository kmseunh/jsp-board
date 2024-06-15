package board;

import common.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardDao {

    private JdbcUtil ju;

    public BoardDao() {
        ju = JdbcUtil.getInstance();
    }

    // 삽입
    public int insert(BoardVo vo) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "INSERT INTO board (title, writer, content) VALUES (?, ?, ?)";
        int ret = -1;
        try {
            con = ju.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getWriter());
            pstmt.setString(3, vo.getContent());
            ret = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }

    // 조회
    public BoardVo selectOne(int num) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM board where num = ?";
        BoardVo vo = null;
        try {
            con = ju.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                updateCnt(num);
                Date regdate = new Date(rs.getTimestamp("regdate").getTime());
                vo = new BoardVo(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), regdate, rs.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return vo;
    }

    public List<BoardVo> selectAll() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM board order by num desc";
        ArrayList<BoardVo> ls = new ArrayList<>();
        try {
            con = ju.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Date regdate = new Date(rs.getTimestamp("regdate").getTime());
                BoardVo vo = new BoardVo(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), regdate, rs.getInt(6));
                ls.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ls;
    }

    // 수정
    public int update(BoardVo vo) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "UPDATE board set title = ?, content = ? WHERE num = ?";
        int ret = -1;
        try {
            con = ju.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContent());
            pstmt.setInt(3, vo.getNum());
            ret = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }

    public int updateCnt(int num) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "UPDATE board set cnt = cnt + 1 WHERE num = ?";
        int ret = -1;
        try {
            con = ju.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, num);
            ret = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }

    // 삭제
    public int delete(int num) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "DELETE FROM board WHERE num = ?";
        int ret = -1;
        try {
            con = ju.getConnection();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, num);
            ret = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }
}
