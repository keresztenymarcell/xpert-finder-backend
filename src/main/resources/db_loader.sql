--
-- PostgreSQL database dump
--

-- Dumped from database version 12.9 (Ubuntu 12.9-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.9 (Ubuntu 12.9-0ubuntu0.20.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Data for Name: booking; Type: TABLE DATA; Schema: public; Owner: csg
--



--
-- Data for Name: expert_info; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.expert_info VALUES (1, 'I am a professional dog-walker. Don''t worry, you won''t regret contacting me! ;)', 7, 3);
INSERT INTO public.expert_info VALUES (2, 'I kill dark wisards as a profession. Also I play seeker.', 3, 4);


--
-- Data for Name: location; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.location VALUES (1, 'Miskolc');
INSERT INTO public.location VALUES (2, 'Budapest');
INSERT INTO public.location VALUES (3, 'Békécsaba');
INSERT INTO public.location VALUES (4, 'Hogwarts');
INSERT INTO public.location VALUES (5, 'Dubai');


--
-- Data for Name: personal_info; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.personal_info VALUES (1, 'revy@gmail.com', 'Rewier Revy', '$2a$10$8lECobp9VNKUPLFES4KM1ODxtMcHi.HkaazluwSxAvqoylMDNyLZW', '12334', 'mégnincs', 0, 'revyke', 1);
INSERT INTO public.personal_info VALUES (2, 'tibor.trial@gmail.com', 'Me Máté', '$2a$10$z0e.RtSxFKGLEK3g9QL7eeg9EfdH7RxKVwBTJUIMH7JuuT9j5ql4y', '222-444', 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.redd.it%2Fxjmijhw09dm11.jpg&f=1&nofb=1', 0, 'Mate11', 2);
INSERT INTO public.personal_info VALUES (3, 'thechosenone@gmail.com', 'Harry Potter', '$2a$10$RflolxmrOEo3Z1PMQ193xOsVqhrqVf2A3U6kBX71LW/MY4ULjnqVy', '123-5555', 'https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fimages4.fanpop.com%2Fimage%2Fphotos%2F18200000%2FHarry-in-HP6-harry-potter-18206052-1575-2100.jpg&f=1&nofb=1', 0, 'potter69', 2);
INSERT INTO public.personal_info VALUES (4, 'random@random.com', 'Random Ramona', '$2a$10$VMiTq/Ix.lzpdsG1OIJtOumMfSKQsGh.mQrSNcJomQETCKlN8sqMK', '123-7777', NULL, 0, 'ramy', 4);


--
-- Data for Name: recommendation; Type: TABLE DATA; Schema: public; Owner: csg
--



--
-- Data for Name: user_; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.user_ VALUES (1, '2022-01-25 14:51:55.437099', '2022-01-25 14:51:55.436605', NULL, 1);
INSERT INTO public.user_ VALUES (2, NULL, '2022-01-25 14:51:55.437335', 1, 2);
INSERT INTO public.user_ VALUES (3, '2022-01-25 14:57:54', '2021-01-25 14:58:03', 2, 3);
INSERT INTO public.user_ VALUES (4, '2022-01-25 15:12:48', '2022-01-25 15:12:51', NULL, 4);


--
-- Data for Name: assignment; Type: TABLE DATA; Schema: public; Owner: csg
--



--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.category VALUES (3, 'Wizardry');
INSERT INTO public.category VALUES (1, 'Health');
INSERT INTO public.category VALUES (2, 'Housework');


--
-- Data for Name: location_expert_infos; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.location_expert_infos VALUES (2, 1);
INSERT INTO public.location_expert_infos VALUES (3, 1);
INSERT INTO public.location_expert_infos VALUES (4, 2);
INSERT INTO public.location_expert_infos VALUES (5, 2);


--
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: csg
--



--
-- Data for Name: profession; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.profession VALUES (1, 'Surgeon', 1);
INSERT INTO public.profession VALUES (2, 'Dog Walker', 2);
INSERT INTO public.profession VALUES (3, 'Auror', 3);
INSERT INTO public.profession VALUES (4, 'Seeker', 3);


--
-- Data for Name: profession_expert_infos; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.profession_expert_infos VALUES (1, 1);
INSERT INTO public.profession_expert_infos VALUES (2, 1);
INSERT INTO public.profession_expert_infos VALUES (3, 2);
INSERT INTO public.profession_expert_infos VALUES (4, 2);


--
-- Data for Name: reference; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.reference VALUES (1, 'A nice dog I''ve walked', 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2Fsd5TBJe8TkI%2Fhqdefault.jpg&f=1&nofb=1', 1);
INSERT INTO public.reference VALUES (2, 'Voldemort. I killed him.', 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fyt3.ggpht.com%2Fa%2FAATXAJzGRFf-wWUwwcHgRIAx3T6wl3NDgwgViC2JNA%3Ds900-c-k-c0xffffffff-no-rj-mo&f=1&nofb=1', 2);


--
-- Data for Name: review; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.review VALUES (1, 'He was very nice to my dog, would recommend 10/10!!!', 5, '2022-01-25 14:51:55.437213', 1, 1);
INSERT INTO public.review VALUES (2, 'He is my hero!!! <3 xoxo', 5, '2022-01-25 15:19:57', 2, 4);


--
-- Data for Name: service; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.service VALUES (1, 'I walk your dog like a pro for half an hour', 'Dog walking-30min', '3000Ft', 1);
INSERT INTO public.service VALUES (2, 'I walk your dog like a pro for an hour', 'Dog walking-60min', '5500Ft', 1);
INSERT INTO public.service VALUES (3, 'Murder a Dark Wizard. Thats it.', 'Dark Wizard Murder', '89000 Ft', 2);
INSERT INTO public.service VALUES (4, 'I can seek the snitch like a pro.', 'Professional Seeker', '100000 Ft / match', 2);


INSERT INTO public.role VALUES(1, 'ROLE_USER');
INSERT INTO public.role VALUES(2, 'ROLE_EXPERT');
INSERT INTO public.role VALUES(3, 'ROLE_ADMIN');





INSERT INTO public.user__roles VALUES(1, 1);
INSERT INTO public.user__roles VALUES(2, 1);
INSERT INTO public.user__roles VALUES(2, 2);
INSERT INTO public.user__roles VALUES(3, 1);
INSERT INTO public.user__roles VALUES(3, 2);
INSERT INTO public.user__roles VALUES(4, 1);



--
-- Name: assignment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

/*SELECT pg_catalog.setval('public.assignment_id_seq', 1, false);*/


--
-- Name: booking_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

/*SELECT pg_catalog.setval('public.booking_id_seq', 1, false);*/


--
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.category_id_seq', 3, true);


--
-- Name: expert_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.expert_info_id_seq', 2, true);


--
-- Name: location_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.location_id_seq', 5, true);


--
-- Name: message_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

/*SELECT pg_catalog.setval('public.message_id_seq', 1, false);*/


--
-- Name: personal_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.personal_info_id_seq', 4, true);


--
-- Name: profession_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.profession_id_seq', 4, true);


--
-- Name: recommendation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

/*SELECT pg_catalog.setval('public.recommendation_id_seq', 1, false);*/


--
-- Name: reference_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.reference_id_seq', 2, true);


--
-- Name: review_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.review_id_seq', 2, true);


--
-- Name: service_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.service_id_seq', 4, true);


--
-- Name: user__id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.user__id_seq', 4, true);


--
-- PostgreSQL database dump complete
--

