- Where and why you have used a @OneToMany annotation
  OneToMany har jeg brugt i både Car og Member klassen. Annotationen er brugt for at vise hvilken relation den har til en anden klasse.
  Som i mit tilfælde er reservation klassen. Det vil sige at min car og member klasse har tilknyttet en liste af reservationer, da en car kan have mange reservationer.
- Where an why you have used a @ManyToOne annotation
  ManyToOne annotationen har jeg så brugt i reservations klassen. I klassen har vi så en refferance til member og car klassen, da en liste af mange reservationer
  skal knyttes til en enkelt car eller member.
- The purpose of the CascadeType, FetchType and mappedBy attributes you can use with one-to-many
  mappedBy bruger jeg i min car og member klassen, så jeg kan bruge referancen af dem over i min reservation klasse.
- How/where you have (if done) added user defined queries to you repositories
  ...
- a few words, explaining what you had to do on your Azure App Service in order to make your Spring Boot App connect to your Azure MySqlDatabase
  ...
- a few words about where you have used inheritance in your project, and how it's reflected in your database
  Jeg har brugt arv på min member klasse for at opdele mine members med forskellige roller, da forskellige former for members skal have forskellige rettigheder
  og jeg skal bruge forskellige informationer baseret på hvilken slags bruger det er.
- What are the pros & cons of using the Single Table Strategy for inheritance?
  ...
- how are passwords stored in the database with the changes suggested in part-6 of the exercise
  Passwords er nu krypteret i databasen, og jeg bruger nu tokens.
