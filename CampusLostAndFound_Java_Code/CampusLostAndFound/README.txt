CAMPUS LOST & FOUND SYSTEM — JAVA CONSOLE PROJECT
=================================================
Requirements: Java 17 or later. No external libraries.

Compile (run from the CampusLostAndFound folder):
  javac -d out src/campuslostfound/*.java tests/campuslostfound/ContractTests.java

Run application:
  java -cp out campuslostfound.Main

Run CO2 contract tests:
  java -cp out campuslostfound.ContractTests

Demo:
- Two sample students and one found wallet (F1) are created automatically.
- Search for wallet using option 3.
- Submit a claim using option 4; item ID F1; evidence: Blue sticker on the back.
- Approve using option 5; claim ID C1.
- View records using option 7.

CO1: entity classes, immutable typed-ID/value records, constructor validation, private state,
controlled state transitions, identity equality, maps, and defensive List.copyOf results.
CO2: documented ClaimVerifier contract, preconditions, postconditions, interface implementations,
shared contract test, and deliberately incorrect saboteur implementation.

This is an in-memory educational prototype. Data resets when the program exits. It does not
yet include a database, real login/authentication, web frontend, or real identity verification.
