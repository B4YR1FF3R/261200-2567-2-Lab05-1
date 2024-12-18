// ตั้ง class ของ USER
class User {
    // กำหนดตัวแปร
    private String name;
    private java.time.LocalDate dob;

    // ตัวเริ่มต้น (Default)
    public User() {
        this.name = null; // set ชื่อว่างไว้
        this.dob = java.time.LocalDate.now(); // set เวลาปัจจุบัน
    }

    // ตัวรับค่า
    public User(String name, int year, int month, int day) {
        this.name = name; // รับชื่อ
        this.dob = java.time.LocalDate.of(year, month, day); // รับวันเกิด
    }

    // ส่งชื่อออก
    public String getName() {
        return name;
    }

    // รับชื่อมา
    public void setName(String name) {
        this.name = name;
    }

    // ส่งวันเกิดออก
    public java.time.LocalDate getDob() {
        return dob;
    }

    // รับวันเกิดมา
    public void setDob(java.time.LocalDate dob) {
        this.dob = dob;
    }

    // ส่งข้อมูลทั้งหมด
    public void displayInfo() {
        System.out.println("Name: " + name); // ส่งชื่อ
        System.out.println("Birthday: " + dob); // ส่งวันเกิด
    }
}

// ตั้ง class ของ Admin(ตัวลูก) เป็น subclass ของ class User(ตัวแม่)
// Admin(ตัวลูก) = subclass : ตัวโม ตัวม็อด "Admin เป็นประเภทของ User ที่มีคุณสมบัติพิเศษเพิ่มเติม (ใช้ได้/เขียนทับได้)"
// User(ตัวแม่) = superclass : ตัวหลัก ไว้กำหนดคุณสมบัติพื้นฐาน
class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(String name, int year, int month, int day) {
        super(name,year,month,day);
    }
    
    // @Override เป็น annotation (ตัวโม ตัวม็อด) ที่เสริมเข้าไปใส่ class USER
    // "ควรใช้ทุกครั้งที่มีการเขียนทับเมธอดของคลาสแม่ เพื่อป้องกันปัญหาและรักษาความสอดคล้องระหว่างคลาสแม่และลูก."
    @Override
    public void displayInfo() {
        super.displayInfo(); // เรียกใช้เมธอด displayInfo() ที่กำหนดไว้ในคลาสแม่ (User) ก่อนที่จะเพิ่มพฤติกรรมใหม่ในคลาสลูก (Admin)
        System.out.println("User type: admin."); // พฤติกรรมใหม่ "ประกาศสถานะผู้ใช้"
    }

    // สร้าง หลายเมธอด ที่มี ชื่อเดียวกัน แต่มี พารามิเตอร์แตกต่างกัน
    // เมธอดที่ Overload ต้องมีความแตกต่างที่ พารามิเตอร์ อย่างใดอย่างหนึ่ง (จำนวน,ชนิด,ลำดับ)
    public void displayInfo(boolean full) {

        // ใส่เงื่อนไขถ้า full เป็นจริงจะส่งชื่อ วันเกิด ประเภทของ USER และวันเวลาปัจจุบัน
        if (full) {
            System.out.println("Name: " + getName());
            System.out.println("Birthday: " + getDob());
            System.out.println("User type: admin.");
            System.out.println("Today's date: " + java.time.LocalDate.now());
        }
        // ถ้าไม่จะส่งแค่ชื่อออกมา
        else
        {
            System.out.println("Name: " + getName());
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        // CASE1 : บัก John (ชื่อ,ปี-เดือน-วัน เกิด)
        User john = new User("John", 1954, 2, 18);
        john.displayInfo();

        // CASE2 : อ้าย Nicolas (ชื่อ,ปี-เดือน-วัน เกิด,สถานะผู้ใช้)
        Admin nicolas = new Admin();
        nicolas.setName("Nicolas");
        nicolas.setDob(java.time.LocalDate.of(1964, 1, 7));

        // ดูอ้าย Nicloas ใหม่หลังจากไปโมไปม็อดมา
        nicolas.displayInfo();

        // CASE3 : อ้าย Nicolas แบบ full (ชื่อ,ปี-เดือน-วัน เกิด,สถานะผู้ใช้,วันเวลาปัจจุบัน)
        System.out.println("\nnicolas displayInfo(true):");
        nicolas.displayInfo(true);

        // CASE4 : อ้าย Nicolas แบบไม่ full (ชื่อ)
        System.out.println("\nnicolas displayInfo(false):");
        nicolas.displayInfo(false);
    }
}
