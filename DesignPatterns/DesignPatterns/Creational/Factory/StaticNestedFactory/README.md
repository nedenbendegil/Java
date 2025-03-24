# Why do i need this pattern?

Control Over Object Creation: By making the constructor private, we ensure documents can only be created through the factory methods.

Simplified Creation API: Users don't need to know the details of how to set up different document types.

Type-Safe Creation: The factory methods ensure proper document type initialization.

Centralized Creation Logic: All document creation happens in one place, making maintenance easier.


