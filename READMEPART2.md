- What are the benefits of using a RESTful API
  Restful Api er enkelte og lette at forstå. De http metoder såsom (get, put, delete osv) er lette og forståelige, i forhold
  til andre mere komplekse protokoler som også findes. Ved hjælp af værktøjet postman, kan vi så også let teste vores http-metoder
  og sikre os at de virker som de skal.
  
- What is JSON, and why does JSON fit so well with REST?
  JSON er en data format, som gør det let for både mennesker og computere at læse. Man bruger oftest JSON til at sende data frem og tilbage
  mellem web serveren og brugeren. Rest og JSON hænger godt sammen, da det bliver gjort nemt og overskueligt for brugeren og serveren at
  kommunikere.
  
- How you have designed simple CRUD endpoints using spring boot and DTOs to separate api from data  -> Focus on your use of DTO's
  Det jeg primært har brugt mine dto klasser til, er at i mine response klasser har vi en constructor som laver vores entity klasser
  om til dto'er i stedet. Det gør at vi kan få lige præcis det data ud af klassen som vi skal bruge. For eksempel, hvis vi skal retunere
  noget tilbage til brugeren, kan vi sortere fra så brugeren kun får de relevante dataer retuneret. Derudover kan vi så også afskaffe
  null værdierne, så det der bliver sendt tilbage til brugeren kun er reel data, og ikke værdier som er null.
  
-  What is the advantage of using using DTOs to separate api from data structure when designing rest endpoints
   Man kan minimere mængden af data der bliver sendt, ved at filtrere så du undgår at sende unødvendige eller private data.
  
- Explain shortly the concept mocking in relation to software testing
  ...
  
- How did you mock database access in your tests, using an in-memory database and/or mockito → Refer to your code
  Jeg har brugt min in-memory database, hvor jeg så har oprettet nogle test medlemmer så jeg har noget test data
  at arbejde med. På den måde kan jeg teste mit service lag, uden faktisk at påvirke min reele database.
  
- Explain the concept Build Server and the role Github Actions play here
  Når jeg pusher mit projekt op på github, vil mine tests så blive kørt. Hvis alle de test går godt, vil github actions
  ikke gøre noget. Men hvis mine test fejler, vil github actions gå ind og stoppe mit commit, så vi undgår, at
  koden der kommer op på det fælles repository ikke virker.
  
- Explain maven, relevant parts in maven, and how maven is used in our CI setup. Explain where maven is used by your GitHub Actions Script(s)
  ...
  
- Understand and chose cloud service models (IaaS, PaaS, SaaS, DBaaS)for your projects -> Just explain what you have used for this handin
  ...
  

