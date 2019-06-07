package com.daydreamdev.secondskill.dao;

import com.daydreamdev.secondskill.pojo.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @auther G.Fukang
 * @date 6/7 11:52
 */
@Mapper
public interface StockMapper {

    @Select("SELECT * FROM stock WHERE id = #{id, jdbcType = INTEGER}")
    Stock selectByPrimaryKey(@Param("id") int id);

    @Update("UPDATE stock SET count = #{count, jdbcType = INTEGER}, name = #{name, jdbcType = VARCHAR}, " +
            "sale = #{sale,jdbcType = INTEGER},version = #{version,jdbcType = INTEGER} " +
            "WHERE id = #{id, jdbcType = INTEGER}")
    int updateByPrimaryKeySelective(Stock stock);

    @Update("UPDATE stock SET sale = sale + 1, version = version + 1 WHERE" +
            "id = #{id, jdbcType = INTEGER} AND version = #{version, jdbcType = INTEGER}")
    int updateByOptimistic(Stock stock);
}
