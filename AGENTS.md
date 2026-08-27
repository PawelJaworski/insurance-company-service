# AGENTS.md

## Paths **Important:**
ALWAYS apply this for the skills which need docs or eventModel directories.
All configurable file/directory paths used by skills and agents. Skills and
agents mentioned in the table below ALWAYS reference these instead of hardcoding paths — keep this section as the
single source of truth. Individual files within each directory are referenced
by their standard filenames (e.g. `commands.md` inside `eventModel`).

| Key | Always use relative path | Always used by                                                                                    |
|-----|--------------------------|---------------------------------------------------------------------------------------------------|
| `docs` | `cd ../docs`             | business-rules-and-definitions, event-modelling, architect, backend-development, backend-plan, backend-generate, development-team |
| `eventModel` | `{docs}`                 | event-modelling, architect, development-team                                                      |

## Project state
Early-stage skeleton. Spring Boot app with almost no domain code yet
(`InsuranceCompanyApplication`, an empty `CommandHandler<T>` interface, one
placeholder `contextLoads` test). Don't assume architecture exists beyond
what's in `src/` — check before extending patterns.

## Efficient exploration patterns
- **Use glob for directory traversal**: Instead of reading directories one level at a time, use patterns like:
  - `src/main/java/**/*.java` — all Java source files
  - `src/main/java/pl/pjaworski/insurance_company/*/` — top-level packages
  - `src/main/java/pl/pjaworski/insurance_company/**/` — all packages recursively
- **Read docs in parallel**: When starting a task, read all relevant docs in one batch:
  - `commands.md`, `events.md`, `readmodels.md`, `uis.md` (event modeling)
  - `business-definitions-raw.md` (business definitions)
- **Check existing code minimally**: Only read files directly related to the change. Don't explore empty directories or read every existing class.
- **Batch writes**: Write all related files in parallel batches instead of one at a time.
- **Verify once**: Run `mvn compile` and `mvn test` only after all files are written.

## Build / test
- `./mvnw` works (`.mvn/wrapper/maven-wrapper.properties` present, pins Maven
  3.9.15 with a SHA-256 checksum). Both `./mvnw` and the system `mvn` are valid
  (Java 25 confirmed working).
- Build: `./mvnw compile` (or `mvn compile`)
- Test: `./mvnw test` (runs a full `@SpringBootTest`, boots Spring context + H2
  in-memory DB — expect Hibernate/Hikari log noise, that's normal)
- No lint/format/codegen tooling configured.
- **Known false-positive LSP noise**: the `jdtls` language server does not
  understand Lombok annotation processing in this project, so it routinely
  reports bogus diagnostics on Lombok-annotated classes — e.g. `getId()`/
  `getAggregateId()`/`setId()` "undefined" on `@Getter`/`@Setter` classes, or
  "blank final field may not have been initialized" on
  `@RequiredArgsConstructor` classes. These are stale/incorrect; do not act on
  them. Treat `mvn compile` / `mvn test-compile` / `mvn test` as the
  authoritative source of truth for whether code actually compiles/passes.

## Stack
- Java 25, Spring Boot 4.1.0 (parent BOM), Maven, Lombok.
- `spring-boot-starter-data-jpa` + H2 (in-memory, runtime scope) + H2 console
  starter, `spring-boot-starter-webmvc`.
- Base package: `pl.pjaworski.insurance_company`.

## Subagents
`.opencode` (symlinked to `../coding-agents`) defines an `architect` subagent
that owns domain modeling/API-contract decisions and enforces model/doc
consistency; it does not write code. Escalate business-intent or modeling
ambiguity rather than guessing.
