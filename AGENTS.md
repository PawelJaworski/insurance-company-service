# AGENTS.md

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

## Stack
- Java 25, Spring Boot 4.1.0 (parent BOM), Maven, Lombok.
- `spring-boot-starter-data-jpa` + H2 (in-memory, runtime scope) + H2 console
  starter, `spring-boot-starter-webmvc`.
- Base package: `pl.pjaworski.insurance_company`.

## Domain model source of truth
Event modeling lives in `event-modelling/*.md` (`commands.md`, `events.md`,
`readmodels.md`) and is the authoritative business/domain model — currently
defines one flow: `accept-policy` command -> `policy-accepted` event ->
`policy-document` read model. `event-modelling/eventmodel.html` is a generated
diagram from these files (see the `event-modelling` skill/plugin under
`.opencode`, which is a symlink to a sibling `coding-agents` repo).
When implementing domain logic, keep code, event-modelling docs, and
ubiquitous language in sync — don't invent fields/events not present in these
files without flagging it.
Business definitions: docs/business-definitions.html
Business rules: docs/business-rules.html

## Subagents
`.opencode` (symlinked to `../coding-agents`) defines an `architect` subagent
that owns domain modeling/API-contract decisions and enforces model/doc
consistency; it does not write code. Escalate business-intent or modeling
ambiguity rather than guessing.
