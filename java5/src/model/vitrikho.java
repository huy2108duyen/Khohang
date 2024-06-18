package model;

import java.util.ArrayList;
import java.util.Objects;

public class vitrikho {
    private int id;
    private String vitrikho;

    public vitrikho(int id, String vitrikho) {
        this.id = id;
        this.vitrikho = vitrikho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVitrikho() {
        return vitrikho;
    }

    public void setVitrikho(String vitrikho) {
        this.vitrikho = vitrikho;
    }

    @Override
    public String toString() {
        return "vitrikho [id=" + id + ", vitrikho=" + vitrikho + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        vitrikho other = (vitrikho) obj;
        return id == other.id && Objects.equals(vitrikho, other.vitrikho);
    }

    public static ArrayList<vitrikho> getDSKho(){
        String[] arr_kho = {
                "Khu Vực A",
                "Khu Vực B",
                "Khu Vực C"};

        ArrayList<vitrikho> listtenKho = new ArrayList<vitrikho>();
        int i = 0;
        for (String tenKho : arr_kho) {
            vitrikho t = new vitrikho(i, tenKho);
            listtenKho.add(t);
            i++;
        }
        return listtenKho;
    }
    public static void main(String[] args) {
        ArrayList<vitrikho> listKho = getDSKho();
        
        if (listKho != null) {
          System.out.println("Danh sách vị trí kho:");
          for (vitrikho vk : listKho) {
            System.out.println(vk);
          }
        } else {
          System.out.println("Không thể lấy danh sách vị trí kho.");
        }
      }
}