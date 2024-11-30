package top.soft.bookonline.entity;


import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/10/19 16:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Integer id;
    private String name;
    private String cover;
    private String author;
    private double price;
    private String introduction;
}
