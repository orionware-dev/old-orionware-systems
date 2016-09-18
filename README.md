# orionware-systems
All Orionware Systems (Core, Web Core, Libraries, etc.)

"general" has the JDK8, Apache Ant and various Java libraries imported
by the Orion projects (including Spring, Apache libraries, etc.).

"tomcat9" is a pre-configured Tomcat 9 as a bundle for Orion.

"core" has some projects used by all others (including abstractions and
marker interfaces.

"reflection" is a library focusing on Java reflection tasks including:
handling classes = loading, instantiation,
handling instance variables = retrieval, accessibility,
handling constructors = retrieval, invocation,
handling methods = retrieval, invocation, accessibility,
handling enumeration = retrieval of values, etc.,
objects = generic object list equality checker, null check for at least 1 object,
accessible objects = retrieval of instance variables, constructors and methods
in one go.

"filesystem"is a library for handling files, directories and IO resources:
handling IO streams, reading and writing to files.

"configuration" is a library that handles configuration properties:
it has a central configuration registry that holds all system properties,
Orion configuration properties plus whatever properties other projects
that use Orion have to register:
handling registration of properties, CRUD operations, checks.

"annotations" is a library that handles Java annotations:
handling retrieval, loading annotations from files, filtering, registration,
processing.

"dependencyinjection" is a library that handles dependency injection of
objects and classes to instance variables and methods.

"computation" is a library that provides annotation for enabling concurrent
execution using all available threads.

"flow" is a library that handles conditionals.

"web" includes web-related projects.

"webcore" is a library that provides abstraction for web-related entities and
functionality.

"webservices" is a library that provides abstraction for web services in general
like RESTful, SOAP, and any other.

"datastructures" is a library that handles data structures, implements an 
Orion-custom list, set, map, etc. (simple and concurrent), provides
factories, streaming.

"designpatterns" is a library that implements design patterns as a service
(DPaaS).

"libraries-tester" is a library that has a JUnit suite class that runs
all libraries test suites in one go. It uses "computation" to enable
concurrent execution if the tests in order to run faster and, at the same time,
test our code for concurrency issues.

"libraries-builder" is an Ant project that builds all libraries.

"orionware-libraries" keeps the JAR files for the Orion libraries generated
by the "libraries-builder".
