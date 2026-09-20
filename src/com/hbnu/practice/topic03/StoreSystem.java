package com.hbnu.practice.topic03;

// 函数式接口
@FunctionalInterface
interface ProductFilter {
    // ✅ 写完整类名 StoreSystem.Product
    boolean accept(StoreSystem.Product p);
}

// 主测试类
public class StoreSystem {
    // 静态内部类
    static class Product {
        String name;
        double price;
        String kittychencategory;

        public Product(String name, double price, String kittychencategory) {
            this.name = name;
            this.price = price;
            this.kittychencategory = kittychencategory;
        }

        @Override
        public String toString() {
            return "商品名: " + name + ", 价格: " + price + ", 分类: " + kittychencategory;
        }
    }

    public static void filterProducts(Product[] products, ProductFilter filter) {
        for (Product product : products) {
            if (filter.accept(product)) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("iPhone", 5999.0, "电子产品"),
                new Product("Java编程书", 79.0, "书籍"),
                new Product("保温杯", 129.0, "家居用品"),
                new Product("平板", 4800.0, "电子产品"),
                new Product("游戏主机", 6299.0, "电子产品")
        };

        // 任务A：匿名内部类
        System.out.println("=====任务A 匿名内部类：价格大于等于5000=====");
        filterProducts(products, new ProductFilter() {
            @Override
            public boolean accept(Product p) {
                return p.price >= 5000.0;
            }
        });

        // 任务B：Lambda最简写法
        System.out.println("\n=====任务B Lambda表达式：分类是电子产品=====");
        filterProducts(products, p -> "电子产品".equals(p.kittychencategory));
    }
}