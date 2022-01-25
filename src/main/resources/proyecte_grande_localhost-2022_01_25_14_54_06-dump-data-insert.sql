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


--
-- Data for Name: location; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.location VALUES (1, 'Miskolc');
INSERT INTO public.location VALUES (2, 'Budapest');
INSERT INTO public.location VALUES (3, 'Békécsaba');


--
-- Data for Name: personal_info; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.personal_info VALUES (1, 'revy@gmail.com', 'Rewier Revy', '123', '12334', 'mégnincs', 0, 0, 'revyke', 1);
INSERT INTO public.personal_info VALUES (2, 'tibor.trial@gmail.com', 'Me Máté', NULL, '222-444', 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.redd.it%2Fxjmijhw09dm11.jpg&f=1&nofb=1', 0, 0, 'Mate11', 2);


--
-- Data for Name: recommendation; Type: TABLE DATA; Schema: public; Owner: csg
--



--
-- Data for Name: user_; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.user_ VALUES (1, '2022-01-25 14:51:55.437099', '2022-01-25 14:51:55.436605', NULL, 1);
INSERT INTO public.user_ VALUES (2, NULL, '2022-01-25 14:51:55.437335', 1, 2);


--
-- Data for Name: assignment; Type: TABLE DATA; Schema: public; Owner: csg
--



--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.category VALUES (1, 'Egészségügy');
INSERT INTO public.category VALUES (2, 'Ház körüli munkák');


--
-- Data for Name: location_expert_infos; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.location_expert_infos VALUES (2, 1);
INSERT INTO public.location_expert_infos VALUES (3, 1);


--
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: csg
--



--
-- Data for Name: profession; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.profession VALUES (1, 'Sebész', 1);
INSERT INTO public.profession VALUES (2, 'Fűnyírós', 2);


--
-- Data for Name: profession_expert_infos; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.profession_expert_infos VALUES (1, 1);
INSERT INTO public.profession_expert_infos VALUES (2, 1);


--
-- Data for Name: reference; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.reference VALUES (1, 'A nice dog I''ve walked', 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2Fsd5TBJe8TkI%2Fhqdefault.jpg&f=1&nofb=1', 1);


--
-- Data for Name: review; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.review VALUES (1, 'He was very nice to my dog, would recommend 10/10!!!', 5, '2022-01-25 14:51:55.437213', 1, 1);


--
-- Data for Name: service; Type: TABLE DATA; Schema: public; Owner: csg
--

INSERT INTO public.service VALUES (1, 'I walk your dog like a pro for half an hour', 'Dog walking-30min', '3000Ft', 1);
INSERT INTO public.service VALUES (2, 'I walk your dog like a pro for an hour', 'Dog walking-60min', '5500Ft', 1);


--
-- Name: assignment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.assignment_id_seq', 1, false);


--
-- Name: booking_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.booking_id_seq', 1, false);


--
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.category_id_seq', 2, true);


--
-- Name: expert_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.expert_info_id_seq', 1, true);


--
-- Name: location_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.location_id_seq', 3, true);


--
-- Name: message_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.message_id_seq', 1, false);


--
-- Name: personal_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.personal_info_id_seq', 2, true);


--
-- Name: profession_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.profession_id_seq', 2, true);


--
-- Name: recommendation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.recommendation_id_seq', 1, false);


--
-- Name: reference_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.reference_id_seq', 1, true);


--
-- Name: review_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.review_id_seq', 1, true);


--
-- Name: service_id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.service_id_seq', 2, true);


--
-- Name: user__id_seq; Type: SEQUENCE SET; Schema: public; Owner: csg
--

SELECT pg_catalog.setval('public.user__id_seq', 2, true);


--
-- PostgreSQL database dump complete
--

