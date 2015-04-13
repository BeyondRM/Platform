  The platform-architecture module is a dependency that many other modules use. It provides common input-output methods
for simplifying and unifying many file operations.

  "Architecture", in this sense, means the assorted abstract classes, interface definitions, and static singleton class
instances that are utilizable for any and every other module in the module-hierarchy. This architecture is like a basic
"foundation" that a building is constructed upon; it provides supporting structural methodologies, used in defining any
other module's implementations.

  One particular aspect, is my "logging support" core singleton class. It pushes all logging to Java's default "logging
system"; however, it may also output a log-file.
