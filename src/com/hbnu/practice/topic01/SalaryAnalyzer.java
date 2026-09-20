package com.hbnu.practice.topic01;

public class SalaryAnalyzer {
    public static void main(String[] args) {
        int[] salaryArray = {4500, 8200, 12000, 5600, 9500, 15000};
        int[] level = new int[3];

        int minSalary = salaryArray[0], maxSalary = salaryArray[0];
        double avgSalary = 0.0;
        for (int i = 0; i < salaryArray.length; i++) {
            //计算最高最低工资，平均薪资
            avgSalary += salaryArray[i]/salaryArray.length;
            if(minSalary > salaryArray[i]) minSalary = salaryArray[i];
            if (maxSalary < salaryArray[i]) maxSalary = salaryArray[i];

            //统计各个级别人数
            if (salaryArray[i] >= 10000) level[0]++;
            else if (salaryArray[i] >= 7000 && salaryArray[i] < 10000) level[1]++;
            else if (salaryArray[i] < 7000) level[2]++;
        }

        System.out.println("最高薪资：" + maxSalary + '\n' + "最低薪资：" + minSalary + '\n' + "平均薪资：" + avgSalary);

        for (int i = 0; i < level.length; i++) {
            System.out.println((char)(i+65) + "级别人数：" + level[i]);
        }
    }
}
