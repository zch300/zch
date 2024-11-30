   package top.soft.brandlist.entity;

   import lombok.Data;
   import lombok.AllArgsConstructor;
   import lombok.NoArgsConstructor;
   import lombok.Builder;

   @Data
   @AllArgsConstructor
   @NoArgsConstructor
   @Builder
   public class Brand {
       private Integer id;
       private String brandName;
       private String companyName;
       private Integer ordered;
       private String description;
   }

