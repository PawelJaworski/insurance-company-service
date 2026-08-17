# AGENTS.md

## Paths
All configurable file/directory paths used by skills and agents. Skills and
agents reference these instead of hardcoding paths — keep this section as the
single source of truth. Individual files within each directory are referenced
by their standard filenames (e.g. `commands.md` inside `eventModel`).

| Key | Default | Used by |
|-----|---------|---------|
| `docs` | `../docs` | business-rules-and-definitions, event-modelling, architect, backend-development, development-team |
| `eventModel` | `{docs}` | event-modelling, architect, development-team |

## Project state
Early-stage skeleton. Spring Boot app with almost no domain code yet
(`InsuranceCompanyApplication`, an empty `CommandHandler<T>` interface, one
placeholder `contextLoads` test). Don't assume architecture exists beyond
what's in `src/` — check before extending patterns.

## Build / test
- `./mvnw` is **broken**: `.mvn/wrapper/` is missing from the repo, so the
  wrapper fails with `cannot read distributionUrl property`. Use the system
  `mvn` instead (Maven 3.9.x, Java 25 confirmed working).
- Build: `mvn compile`
- Test: `mvn test` (runs a full `@SpringBootTest`, boots Spring context + H2
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
