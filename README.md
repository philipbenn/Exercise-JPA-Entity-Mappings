The idea with, and reasons for why to use, a ORM-mapper
Brugen af ORM-mapper gør det simplere at arbejde med database, da du kan opbygge en database i din kode, i stedet for inde i mysql. 
   
The meaning of the terms JPA, Hibernate and Spring Data JPA and how they are connected
JPA:  JPA giver en mulighed for at arbejde med databaser ved at bruge objektorienteret programmering, hvor de kan bruge Java-objekter til at repræsentere data i databasen.
Hibernate: Det er et libary i java, der bruges til at gøre arbejdet lettere at mappe Java-objekter til databasetabeller.
Spring Data JPA: Spring Data JPA tilbyder en række foruddefinerede metoder
   
How to create simple Java entities and map them to a database via the Spring Data API
Ved hjælp af @Table, @Id og @Column annotationerne i entity klassen, kan man opsætte en tabel med kollonner og primær nøgle,
uden at lave nogle scripts eller lignende i MySql Workbench.
   
How to control the mapping between individual fields in an Entity class and their matching columns in the database
Ved brug af annotationen @Column kan man sætte navnet i databasen til at være noget andet, end hvad attributten hedder i java klassen.
   
How to auto generate IDs, and how to ensure we are using  a specific database's preferred way of doing it (Auto Increment in our case for  MySQL)
Jeg bruger annotationerne @Id og @GeneratedValue til at identificere primær nøglen, og auto generere en unik værdi.
   
How to use and define repositories and relevant query methods using Spring Data JPAs repository pattern
   Først laver du en entity klasse, med de relevante annotationer der skal bruges. Derefter kan du så lave en repository interface der extender JPARepository,
   som der så giver der adgang til en masse crud metoder.
   
How to add (dev) connection details for you local MySQL database
Inde i application properties tilføjede jeg et url til min database, samt mit username og password til at kunne logge ind på sql workbench.
