<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="oracle.jdbc.driver.OracleDriver"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.Properties"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Session"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JavaCrab</title>
    <link rel="icon" type="image/png" href="w1.jpg">
     <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #000;
            color: white;
            text-align: center;
        }

        header {
            background-color: #111;
            padding: 1rem;
            border-bottom: 1px solid #333;
            display: flex;
            justify-content: space-between;
            align-items: center;
            position: fixed;
            top: 0;
            width: 100%;
            z-index: 100;
        }

        nav ul {
            list-style-type: none;
            display: flex;
            gap: 20px;
        }

        nav ul li a {
            color: white;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        .nav-icons {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .github-stars {
            font-size: 16px;
        }

        .icon {
            width: 20px;
            height: 20px;
        }

        main {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 80vh;
            }

        .logo {
            width: 96px;
            height: 85px;
            margin-bottom: 20px;
        }

        h1 {
            color: rgb(255, 81, 0);
            font-size: 48px;
            margin-bottom: 10px;
          
        }
       

        p {
            font-size: 18px;
            margin-bottom: 30px;
        }

        .subscribe-form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        input[type="email"] {
            padding: 10px;
            border: none;
            width: 300px;
            border-radius: 5px;
            margin-right: 10px;
            margin-bottom: 13px;
        }

 
      

        .subscribe-form button {
            padding: 10px 25px;
            background-color: #ff6600;
            color: rgb(255, 255, 255);
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        .subscribe-form button:hover {
            background-color: rgb(255, 17, 0);
        }

        nav a:hover {
            color: #ff6600;
            border-bottom: 2px solid #ff6600;
        }

        section:target {
            display: block;
        }

        .container {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 20px;
    padding-bottom: 70px; 
}


        .book {
            background-color: #2c2c2c;
            border-radius: 10px;
            text-align: center;
            transition: transform 0.3s ease;
            flex: 0 0 28%; 
            margin: 8px;
            margin-top:80px;
        }

        
       

        .book:hover {
            transform: scale(1.05);
            box-shadow: 0 0 10px #ffffff;
           
        }

        .book img {
            width: 100px;
            height: 130px;
            object-fit: cover;
            margin-bottom: 15px;
        }
        
        html {
            scroll-behavior:smooth;
        }

        .project {
  background-color: #2c2c2c;
  border-radius: 10px;
  text-align: center;
  transition: transform 0.3s ease;
  flex: 0 0 28%; 
  margin: 8px;
  margin-top:250px;
}

.project:hover {
  transform: scale(1.05);
  box-shadow: 0 0 10px #ffffff;
}

.project img {
  width: 100px;
  height: auto;
  object-fit: cover;
  margin-bottom: 15px;
  margin-top: 10px;
}

.project h3 {
  color: white;
  margin-bottom: 10px;
  font-size: 24px;
  font-weight: bold;
}

.project p {
  color: white;
  margin-bottom: 20px;
  text-align: center;
  font-size: 20px;
}
#project_h3
{
    margin-top: 50px;
}



#txtspringboot
{
    margin-top: 12px;
}

.lesson {
  background-color: #000000;
  border-radius: 10px;
  text-align: center;
  transition: transform 0.3s ease;
  flex: 0 0 28%; 
  margin: 8px;
  margin-top: 30px;
}

.lesson:hover {
  transform: scale(1.05);
  box-shadow: 0 0 5px #000000;
}

.lesson iframe {
  width: 90%;
  height: 90%;
  object-fit: cover;
  margin-top: 40px;
  margin-bottom: 40px;
}

.row {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
}
#devtools {
    background-color: #000000;
    border-radius: 10px;
    text-align: center;
    transition: transform 0.3s ease;
    flex: 0 0 28%;
    margin: 8px;
    margin-top: 1px;
    margin-bottom: 50px; 
    padding-bottom: 200px; 
}

#devtools img {
  width: 100px;
  height: auto;
  object-fit: cover;
  margin-bottom: 13px;
  margin-top: 10px;
}

#devtools h3 {
  color: white;
  margin-bottom: 3px;
  font-size: 24px;
  font-weight: bold;
}

.people {
  background-color: #2c2c2c;
  border-radius: 10px;
  text-align: center;
  transition: transform 0.3s ease;
  flex: 0 0 28%; 
  margin: 8px;
  margin-top: 250px;
  margin-bottom: 70px; /* added margin bottom */
}

.people:hover {
  transform: scale(1.05);
  box-shadow: 0 0 10px #ffffff;
}

.people img {
  width: 100px;
  height: auto;
  object-fit: cover;
  margin-bottom: 15px;
  margin-top: 10px;
}

.people h3 {
  color: white;
  margin-bottom: 10px;
  font-size: 24px;
  font-weight: bold;
}

.people p {
  color: white;
  margin-bottom: 20px;
  text-align: center;
  font-size: 20px;
}




main:nth-child(2) 
        {
        display: block;
        width: 100%;
        margin-top: 85px; 
    }
    main:nth-child(3) 
        {
        display: block;
        width: 100%;
        margin-top: 200px; 
        
    }
    main:nth-child(4) 
        {
        display: block;
        width: 100%;
        margin-top: 80px; 
    }
    main:nth-child(5)
    {
        display: block;
        width: 100%;
        margin-top:140px;
    }
    main:nth-child(6)
    {
      display: block;
      width: 100%;
      margin-top: 160px;
    }
       
    </style>
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="#">JavaCrab</a></li>
                <li><a href="#books">Books</a></li>
                <li><a href="#projects">Projects</a></li>
                <li><a href="#lessons">Lessons</a></li>
                <li><a href="#devtools">Dev Tools</a></li>
                <li><a href="#People">People</a></li>
            </ul>
        </nav>
        <div class="nav-icons">
            <span class="github-stars">403 ★</span>
            <img src="github.png" alt="Icon" class="icon" draggable="false">
        </div>
    </header>

    <form class="subscribe-form" method="post" action="crab_Main.jsp"> 
    <main>
            <img src="w1.jpg" alt="Java Logo" class="logo" draggable="false">
            <h1>JAVA CRAB</h1>
            <p>An Open source project with everything you need to learn about Java</p>
           
                <p>Join 2600+ Java Dev s. Subscribe to get exclusive stuff</p>
                <input type="email" placeholder="example@gmail.com" name="txt1" required>
                <button type="submit" name="gg">Subscribe</button>
                
             <%
String data = request.getParameter("txt1");

if(data != null && !data.isEmpty()) {
    try {
        DriverManager.registerDriver(new OracleDriver());
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "manager");
        System.out.println("Database connection established successfully");
        
        String sql = "insert into email1 values(?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, data);
        System.out.println("SQL query prepared successfully");
        
        int x  = pst.executeUpdate();
        System.out.println("Data inserted successfully");
        
        if(x > 0) {
            out.print("DATA SAVED");
        } else {
            out.print("ERROR");
        }
    } catch(SQLException e) {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
    } catch(Exception e) {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
}
%>
    </main >
    <main>
        
        
       
        <section id="books">
            
             <div class="container">
                
                <div class="book">
                
                    
                  
                 <a href="https://www.amazon.in/Java-Programmer-Exam-Guide-1Z0-809/dp/1260117383/ref=pd_sbs_d_sccl_3_2/262-7616119-0954612?pd_rd_w=HKYJC&content-id=amzn1.sym.d4089320-ab32-4dd6-a621-3f0516aefb4d&pf_rd_p=d4089320-ab32-4dd6-a621-3f0516aefb4d&pf_rd_r=V22ZFT55A9PQ2MHGZPME&pd_rd_wg=tPEGt&pd_rd_r=a2204a52-49a9-4766-adcc-3a512bd58484&pd_rd_i=1260117383&psc=1" target="_blank"> <img src="javabook1.png" alt="lol1" draggable="false"></a>
                    <h3>OCA Java SE 8 </h3>
                    <p>A practical Java guide to go from beginner to expert and become a proficient, qualified developer.</p>
                </div>
                <div class="book">
                    
                    <a href="https://www.oreilly.com/library/view/java-the-complete/9781260440249/" target="_blank"> <img src="javabook2.png" alt="lol2" draggable="false"></a>
                  
                    <h3>Java The Complete Reference</h3>
                    <p>An introductory book to Java, covering the language from basics to advanced topics.</p>
                </div>
                <div class="book">
                    <a href="https://www.amazon.in/Core-Advanced-Java-Black-Recommended/dp/9351199401" target="_blank" ><img src ="javabook3.png" alt="lol3" ></a>
                    <h3>Core Java An Integrated Approach </h3>
                    <p>A comprehensive guide to Java programming focusing on systems-level programming.</p>
                </div>
                <div class="book">
                    <a href="https://www.amazon.in/Head-First-Java-Brain-Friendly-Grayscale/dp/9355420900" target="_blank" ><img src="javabook4.png" alt="lol4" ></a>
                    <h3>Head First Java</h3>
                    <p>A beginner-friendly book that teaches Java through interactive examples and exercises.</p>
                </div>
                <div class="book">
                    <a href="https://www.amazon.com/Java-All-One-Dummies-Doug-dp-1119986648/dp/1119986648?&linkCode=sl1&tag=29834000-20&linkId=f044b0d057805bf19e3777594c999cdd&language=en_US&ref_=as_li_ss_tl" target="_blank"> <img src="javabook5.png" alt="lol5" draggable="false"></a>
                    <h3>Java All-in-One For Dummies</h3>
                    <p>A comprehensive guide to optimizing Java performance, covering topics like garbage collection and concurrency.</p>
                </div>
                <div class="book">
                    <a href="https://www.amazon.com/dp/B076926QSX?th=1&psc=1&linkCode=sl1&tag=29834000-20&linkId=d89d4dab4465933da38d8542cce9191e&language=en_US&ref_=as_li_ss_tl" target="_blank" ><img src="javabook6.png" alt="lol6" ></a>
                    <h3>Java: Programming Basics for Absolute Beginners</h3>
                    <p>A detailed guide to multithreading in Java, covering topics like thread synchronization and deadlock avoidance.</p>
                </div>
            </div>
        </section>
    </main>

   
    <main>
      <section id="projects">
        <div class="container">
          <div class="project">
            <h3 style="color:#ff6600; font-size:30px;">Spring</h3>
            <a href="https://github.com/spring-projects/spring-framework" target="_blank"><img src="javaspring.png"></a>
            <p>Lightweight Java-based framework for building enterprise apps.
            Simplifies Java development.</p>
          </div>
          <div class="project">
            <h3 style="color:#ff6600; font-size:30px;">Spring Boot</h3>
            <a href="https://github.com/spring-projects/s pring-boot" target="_blank"><img src="javaspringboot.png"></a>
            <p>Simplifies app development with auto-configuration and embedded servers.
            Enables rapid, production-ready deployments.</p>
          </div>
          <div class="project">
            <h3 style="color: #ff6600; font-size:30px;">Hibernate</h3>
            <a href="https://github.com/hibernate" target="_blank"><img src="hibernet.png"></a>
            <p>Open-source Java ORM framework for database independence.
            Enables persistence logic in Java apps.</p>
          </div>
        </div>
      </section>
    </main>


      <main>
        <section id="lessons">
           
          <div class="row">
            <div class="lesson">
              <iframe src="https://www.youtube.com/embed/xk4_1vDrzzo" title="Java From Scratch To Advance Within 12 Hours" allowfullscreen></iframe>
            </div>
            <div class="lesson">
                <iframe src="https://www.youtube.com/embed/2ZLl8GAk1X4" allowfullscreen></iframe>
              </div>
            <div class="lesson">
              <iframe src="https://www.youtube.com/embed/5rNk7m_zlAg" allowfullscreen></iframe>
            </div>
            <div class="lesson">
                <iframe src="https://www.youtube.com/embed/Nefd6qdpdSI" allowfullscreen></iframe>
              </div>
              <div class="lesson">
                <iframe src="https://www.youtube.com/embed/5PdEmeopJVQ" allowfullscreen></iframe>
              </div>
              
            
          </div>
        </section>
      </main>

      <main>
        <section id="devtools">
          <div class="container">
            <div class="project">
              <h3 style="color:#ff6600; font-size:30px;">Code Anywhere</h3>
              <a href="https://codeanywhere.com/languages/spring" target="_blank"><img src="codeanywhere.png"></a>
              <p>Code Anywhere is a cloud-based IDE that lets you write, run, and debug Java code from any device, offering collaborative development and version control.</p>
            </div>
            <div class="project">
              <h3 style="color:#ff6600; font-size:30px;">Replit</h3>
              <a href="https://replit.com/languages/java" target="_blank"><img src="reple.png"></a>
              <p>Replit is a cloud-based code editor and IDE for Java, featuring real-time collaboration, version control, and extensive coding resources.</p>
            </div>
            <div class="project">
              <h3 style="color:#ff6600; font-size:30px;">Jira</h3>
              <a href="https://www.atlassian.com/software/jira" target="_blank"><img src="jira.png"></a>
              <p>Jira is a project management tool for tracking and managing projects, issues, and tasks, essential for agile development teams.</p>
            </div>
          </div>
        </section>
      </main>
      <main>
        <section id="People">
          <div class="container">
            <div class="people">

              <h3 style="color: #ff6600; font-size: 24px;">Pranav Gor</h3>
              <h3 style="color:lightskyblue; font-size:12px;">Founder & Community Manager</h3>
              <p>Creator of JavaCrab and passionate Software Engineer from India. Focused on building a community that empowers Java developers to grow and learn together.</p>
              <a href="https://github.com/Pranav-Gor" target="_blank"><img src="github.png" alt="GitHub" style="width: 20px; height: 20px; margin-top: 10px;"></a>
            </div>
            <div class="people">
            
              <h3 style="color: #ff6600; font-size: 24px;">Ricken Paramar</h3>
              <h3 style="color:lightskyblue; font-size:12px;">Community Admin & Tester</h3>
              <p>Dedicated tester and community admin, ensuring the quality and integrity of JavaCrab's resources. Passionate about helping others and making the community a better place.</p>
              <a href="https://github.com/Ricken1025" target="_blank"><img src="github.png" alt="GitHub" style="width: 20px; height: 20px; margin-top: 10px;"></a>
            </div>
          </div>
        </section>
      </main>
      
      <footer>
        <p>&copy;  2024 JavaCrab. All Rights Reserved.</p>
    </footer>
</form>




</body>
</html>