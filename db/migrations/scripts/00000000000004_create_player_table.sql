--
--    Copyright 2010-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

-- // create_user
-- Migration SQL that makes the change goes here.

CREATE TABLE PLAYER (
  ID UUID PRIMARY KEY,
  FIRST_NAME TEXT NOT NULL,
  LAST_NAME TEXT NOT NULL,
  POSITION_ID INTEGER REFERENCES POSITION(ID)
);

CREATE TABLE TEAM (
  ID UUID PRIMARY KEY,
  NAME TEXT NOT NULL
);

CREATE TABLE TEAM_PLAYER (
  TEAM_ID UUID REFERENCES TEAM(ID),
  PLAYER_ID UUID REFERENCES PLAYER(ID)
);

-- //@UNDO
-- SQL to undo the change goes here.

DROP TABLE IF EXISTS TEAM_PLAYERS;
DROP TABLE IF EXISTS TEAM;
DROP TABLE IF EXISTS PLAYER;
