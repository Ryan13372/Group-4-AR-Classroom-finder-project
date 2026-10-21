# Team Design Document (Design Proposal)

**Course:** CSSD 1161 — Communication & Teamwork in Software Development  
**Team Name/Number:** Group 4  
**Term:** Fall 2026 (Semester 1)  
**Version:** 1.0 (Design Proposal Final)  
**Member Information:** Grant (Coordinator), Ryan (Dev), Andrew (Documentation), Yash (Reviewer)  

---

## 1) Project Overview

### 1.1 Problem Statement
First-year York University students often get lost in unfamiliar campus buildings because the layouts are confusing, hallways are crowded, and signs are hard to find, especially when in a rush. This makes moving between classes stressful and causes students to be late or miss lectures. Providing easy, step-by-step indoor directions helps new students find their classrooms quickly and show up on time.

### 1.2 Users & Context
* **Primary users:** First-year York University students and campus visitors (like Jordan and Daniel)
* **User Needs:**
  * A query field for immediate room search, only requiring some tapping
  * Clear, step-by-step visual guidance through indoor spaces
  * Ability to find key amenities like washrooms and exits nearby, and checkpoints (completion milestones)
* **Context & constraints:**
  * Mobile smartphone devices (iOS/Android) with camera access
  * Indoor cellular data and campus WiFi can be spotty and slow at times
  * Must remain clear and accessible while walking in crowded, fast-moving hallway environments

### 1.3 Value Proposition
Our AR Classroom Finder eliminates the confusion of indoor navigation by overlaying real-time directional arrows directly onto a student’s live camera view. Unlike PDF campus maps or standard outdoor GPS tools that fail indoors, our visual cues guide users step-by-step straight to their classroom door, saving critical time between classes.

### 1.4 Goals & Non-Goals

#### Goals (In-Scope - MVP)
* Search capability for a subset of York University campus buildings and rooms
* Search box that basically looks up the rooms for specific campus areas
* Interactive Figma prototype demonstrating AR directional arrows and floor-level routing
* Clear visual feedback upon reaching the target classroom (arrival screen)

#### Non-Goals (Out-of-Scope - Future Areas)
* Turn-by-turn outdoor navigation across the entire university campus grounds
* Full real-time integration with York University's official student portal or course schedules
* Support for every single campus building in the initial prototype version

## 2) Requirements

### 2.1 User Stories (MoSCoW)

| ID | As a… | I want… | So that… | Priority (M/S/C/W) |
| :--- | :--- | :--- | :--- | :--- |
| **US-01** | First-year student | to search for my classroom by room number | I can find where my class is located quickly. | **Must Have** |
| **US-02** | Student rushing between classes | to see AR directional arrows on my screen | I can easily follow the route to my room. | **Must Have** |
| **US-03** | New student | to view an arrival message when I reach my room | I know I have reached the right room before walking in. | **Must Have** |
| **US-04** | Transfer student | to see what floor my classroom is on | I don't waste time searching on the wrong floor. | **Should Have** |
| **US-05** | Campus Visitor | to find nearby washrooms and exits | I can easily locate essential amenities in an unfamiliar building. | **Could Have** |
| **US-06** | Daily commuter student | to save my frequent classrooms as favorites | I can start navigation faster for my daily schedule. | **Won't Have** |

### 2.2 Acceptance Criteria (Given/When/Then)

#### Traceability to US-01 (Search Classroom)
* **Given** that I am on the search screen, 
* **When** I enter a room number (e.g., `"MK 102"`) and tap search, 
* **Then** the app displays the classroom details and a *"Start Navigation"* button.

#### Traceability to US-02 (AR Directional Arrows)
* **Given** that I have started navigation, 
* **When** I point my camera down the hallway, 
* **Then** 3D AR arrows appear on screen indicating the correct direction to walk.

#### Traceability to US-03 (Arrival Confirmation)
* **Given** I am following the AR route, 
* **When** I arrive at the target classroom door, 
* **Then** a popup message appears stating *"You have arrived at MK 102."*

### 2.3 Assumptions & Constraints
* **Technical Limits:** Indoor GPS signal can be weak; navigation relies on camera positioning and pre-mapped building visual markers.
* **Time & Skills:** Limited to the course duration, the prototype will be built as an interactive Figma simulation rather than a fully compiled native app.
* **Devices:** Requires a mobile device (smartphone) with a working camera and a screen capable of running the interactive Figma prototype.
* **Data & Privacy:** Uses simulated campus map data and sample room layouts; no actual student personal data or location tracking histories are saved or collected.

* ## 3) Figma Design

### 3.1 Figma Links
* **Design File:** [Figma Design Link](https://www.figma.com/design/v7gkLTEU9ZaeoFBZP7p59V/Prototype?node-id=0-1&p=f&t=yNoPDl7aWntt0aaJ-0)
* **Prototype:** [Figma Interactive Prototype](https://www.figma.com/proto/v7gkLTEU9ZaeoFBZP7p59V/Prototype?node-id=0-1&p=f&t=yNoPDl7aWntt0aaJ-0&scaling=scale-down&content-scaling=fixed&page-id=0%3A1)
* **Design System:** [Figma Design System](https://www.figma.com/design/v7gkLTEU9ZaeoFBZP7p59V/Prototype?node-id=0-1&p=f&t=yNoPDl7aWntt0aaJ-0) *(Included in main Design File)*

### 3.2 Screen Inventory

| Screen ID | Name | Purpose | Status | Link |
| :--- | :--- | :--- | :--- | :--- |
| **SCR-01** | Search Screen | Allows users to enter a classroom number to begin navigation. | **Complete** | [View Screen](https://www.figma.com/design/v7gkLTEU9ZaeoFBZP7p59V/Prototype?node-id=0-1&p=f&t=yNoPDl7aWntt0aaJ-0) |
| **SCR-02** | Navigation Screen | Displays real-time AR directional arrows to guide the user to their target room. | **Complete** | [View Screen](https://www.figma.com/design/v7gkLTEU9ZaeoFBZP7p59V/Prototype?node-id=0-1&p=f&t=yNoPDl7aWntt0aaJ-0) |
| **SCR-03** | Arrival Screen | Confirms that the user has successfully reached the destination classroom. | **Complete** | [View Screen](https://www.figma.com/design/v7gkLTEU9ZaeoFBZP7p59V/Prototype?node-id=0-1&p=f&t=yNoPDl7aWntt0aaJ-0) |

### 3.3 User Flows

#### Primary Flow: Classroom Search to Arrival
* **Flow Path:** Search Screen (`SCR-01`) → Navigation Screen (`SCR-02`) → Arrival Screen (`SCR-03`)
* **Description:** A student enters a room number on campus and follows visual AR directional cues until reaching their destination classroom.

**Success Criteria:**
1. **Valid Input & Route Generation:** Entering a valid room number successfully transitions the user from the Search Screen to the AR Navigation view within 2 seconds.
2. **Real-Time Guidance:** The AR arrow updates continuously as the user moves, maintaining clear direction without losing visual tracking.
3. **Arrival Confirmation:** The app automatically triggers the Arrival Screen and displays a visual completion badge when the user is within 2 meters of the target room.

### 3.4 Accessibility in Design
* Visual elements maintain proper color contrast ratios for high visibility while walking.
* Structured focus ordering for all interactive elements
<img width="781" height="327" alt="image" src="https://github.com/user-attachments/assets/d3b4c094-198b-45f4-b842-ec75969c2c37" />

## 4) Information Architecture & Data

### 4.1 Sitemap / Navigation
<img width="346" height="327" alt="image" src="https://github.com/user-attachments/assets/80ae9f67-9885-40f8-be04-84ac11a97b02" />

### 4.2 Content / Data Model

| Entity | Key Fields | Notes |
| :--- | :--- | :--- |
| **Building** | `building_id`, `building_name`, `building_code`, `total_floors` | Maps campus codes (e.g., `"MK"`) to physical locations. |
| **Room** | `room_id`, `room_number`, `building_id`, `floor_number` | Stores classroom locations and connects each room to a building and floor. |
| **Amenity** | `amenity_id`, `amenity_type`, `building_id`, `floor_number`, `location` | Stores nearby amenities such as washrooms and exits. |

## 5) UI Specifications

### 5.1 Layouts per Screen

#### SCR-01 — Search Screen
* **Layout:** Search bar centered near the top with a search button and recent/quick options below.
* **Spacing:** Consistent spacing between the search bar, buttons, and room for information.
* **Breakpoints:** Designed for mobile smartphone screens.
* **Annotations:** Search field shows where users enter the room number.

#### SCR-02 — Navigation Screen
* **Layout:** Full-screen camera/AR view with directional arrows and destination information.
* **Spacing:** AR directions remain clearly separated from other interface elements.
* **Breakpoints:** Designed for mobile smartphone screens.
* **Annotations:** Directional arrows show the user where to walk.

#### SCR-03 — Arrival Screen
* **Layout:** Large arrival confirmation in the center with the classroom number and completion message.
* **Spacing:** Large spacing around the confirmation message for easy visibility.
* **Breakpoints:** Designed for mobile smartphone screens.
* **Annotations:** "You Have Arrived" clearly confirms the destination.

---

### 5.2 Style Guide

#### Colors
* **Primary / Navigation:** `#FFFFFF` (White)
* **Background:** `#6366F1` (Indigo)
* **Success / Arrival:** `#22C55E` (Green)
* **Errors:** `#EF4444` (Red)

#### Typography
* **Headings:** Bold, large text
* **Body:** Regular, readable text
* **Buttons:** Medium/Bold text

#### Iconography
* Simple, high-contrast icons for search, navigation, washrooms, exits, and arrival confirmation.

#### Components & States
* **Buttons:** Default, hover, focus, disabled
* **Search bar:** Default, active, error
* **Navigation arrows:** Active while navigating
* **Arrival message:** Success state
* **Error message:** Displayed when a room cannot be found
## 6) Interaction Design

### States & Behaviors
* **Loading:** Shows a loading message while the route is being generated.
* **Empty:** Shows "No room found" if the user enters an invalid room.
* **Success:** Shows "You Have Arrived" when the user reaches the classroom.
* **Error:** Shows an error message if directions cannot be generated.

### Keyboard Interactions & Focus Management
* Search fields can be selected and used with a keyboard.
* Buttons have a clear focus state.

### Microcopy
* **Error:** "Room not found. Please check the room number."
* **Empty state:** "No results found."
* **Button labels:** "Search", "Start Navigation", and "Done."
* **Arrival message:** "You Have Arrived."

---

## 7) System Overview (Lightweight)

### Architecture
The AR Classroom Finder consists of a mobile interface, a simulated navigation system, and campus map data. The user enters a classroom number, the system finds the room and floor, and the prototype displays the navigation route and AR directional arrows.

### Simple Flow

User
↓
Search Screen
↓
Room / Building Data
↓
Navigation Screen
↓
Arrival Screen

### External Services
* No external services are used in the current Figma prototype.
* Campus maps and room information are simulated for the prototype.

---

## 8) GitHub Workflow (Course Conventions)

* **Repository URL:** [Group-4-AR-Classroom-finder-project](https://github.com/Ryan13372/Group-4-AR-Classroom-finder-project)
* **Default Branch:** `main`
* **Branching Strategy:** Team members create separate branches for their work and merge completed changes into `main`.
* **Issues/Milestones:** GitHub Issues are used to track tasks, bugs, and project work. Milestones are used to organize major deadlines.
* **PR Checklist:** Before merging, changes should be tested, reviewed by a team member, and checked for conflicts or errors.

---

## 9) Testing Plan

### Usability Testing
Three participants will test the AR Classroom Finder by completing the following task:  
* **Task:** Find classroom MK 102 using the AR Classroom Finder and navigate to the classroom.  

**Success Criteria:**
* Participants can find the classroom using the search feature.
* Participants can follow the AR directions.
* Participants can identify when they arrive.
* Participants can complete the task without major confusion.

### Functional Testing
* **Happy Path:** Enter a valid room number → receive directions → reach the classroom → see arrival confirmation.
* **Edge Path:** Enter an invalid room number → receive a clear "Room not found" message.
* **Edge Path:** Search for a room on a different floor → system displays the correct floor before navigation.
* **Traceability:** Testing is connected to **US-01** (search classroom), **US-02** (AR directions), **US-03** (arrival confirmation), and **US-04** (floor information).

---

## 10) Accessibility & Inclusion
* **Keyboard-only navigation:** Users can move between the search field and buttons using the keyboard.
* **Alt text:** Images and important visual elements have descriptions for users who cannot see them.
* **Labels:** Buttons and input fields have clear labels such as "Search" and "Start Navigation."
* **Error recovery:** Clear error messages explain what went wrong and how to fix it.
* **Inclusive language:** Use simple, respectful language that does not exclude or assume anything about the user.

---

## 11) Risks & Mitigations

| Risk | Impact | Likelihood | Mitigation |
| :--- | :--- | :--- | :--- |
| Indoor GPS or AR tracking is inaccurate | High | Medium | Use simulated AR directions and pre-mapped building data in the prototype. |
| Users have difficulty understanding the AR directions | Medium | Medium | Use large, clear arrows and test the prototype with users. |
| Building layouts or room information are incorrect | High | Low | Use verified sample building and room information. |

---

## 12) Milestones & Schedule

| Milestone | Date | Deliverable |
| :--- | :--- | :--- |
| **Design Freeze** | Week 4 | Figma screens & flows |
| **MVP Build** | Week 5 | Completed prototype with search and navigation / Proper UX and UI Experience |
| **Demo** | Week 6 | Final prototype demonstration |

---

## 13) Submission Checklist

- [ ] Figma links (design + prototype)
- [ ] Screenshots per key screen
- [ ] User stories + acceptance criteria
- [ ] Screen inventory & flows
- [ ] Style guide & interaction states
- [ ] GitHub repo URL and PR/Issue links
- [ ] Usability + functional checks
- [ ] Accessibility notes
- [ ] Risks & timeline
