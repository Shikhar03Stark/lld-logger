```
+---------------------+
|     LogLevel        |
|---------------------|
| + CRITICAL: LogLevel|
| + ERROR: LogLevel   |
| + WARNING: LogLevel |
| + INFO: LogLevel    |
| + DEBUG: LogLevel   |
| + TRACE: LogLevel   |
|---------------------|
| + getLevel(): int   |
+---------------------+

+---------------------+
|   LoggerService     |
|---------------------|
| + log(LogLevel,     |
|   String): void     |
| + setLogLevel(      |
|   LogLevel): void   |
| + getLogLevel():    |
|   LogLevel          |
+---------------------+
            ^
            |
+---------------------+
| LoggerServiceImpl   |
|---------------------|
| - sinkFactory:      |
|   SinkFactory       |
| - logLevel: LogLevel|
|---------------------|
| + log(LogLevel,     |
|   String): void     |
| + setLogLevel(      |
|   LogLevel): void   |
| + getLogLevel():    |
|   LogLevel          |
| - shouldLog(        |
|   LogLevel): boolean|
+---------------------+

+---------------------+
|     SinkFactory     |
|---------------------|
| + getWriter():      |
|   SinkWriter        |
+---------------------+
            ^
            |
+---------------------+        +---------------------+
| ConsoleSinkFactory  |        |  FileSinkFactory    |
|---------------------|        |---------------------|
| - sinkFactory:      |        | - filePath: String  |
|   SinkFactory       |        | - writer: SinkWriter|
|---------------------|        |---------------------|
| + getWriter():      |        | + getWriter():      |
|   SinkWriter        |        |   SinkWriter        |
| + getInstance():    |        | + getInstance(      |
|   SinkFactory       |        |   String):          |
|                     |        |   SinkFactory       |
+---------------------+        +---------------------+

+---------------------+
|     SinkWriter      |
|---------------------|
| + getSinkType():    |
|   SinkType          |
| + write(LogLevel,   |
|   String): void     |
| + close(): void     |
+---------------------+
            ^
            |
+---------------------+        +---------------------+        +---------------------+
| ConsoleSinkWriterImpl|       | FileSinkWriterImpl  |        | DatabaseSinkWriterImpl|
|---------------------|        |---------------------|        |---------------------|
| - filePath: String  |        | - filePath: String  |        |---------------------|
|---------------------|        |---------------------|        | + write(LogLevel,   |
| + getSinkType():    |        | + getSinkType():    |        |   String): void     |
|   SinkType          |        |   SinkType          |        | + close(): void     |
| + write(LogLevel,   |        | + write(LogLevel,   |        | + getSinkType():    |
|   String): void     |        |   String): void     |        |   SinkType          |
| + close(): void     |        | + close(): void     |        +---------------------+
+---------------------+        +---------------------+
```
