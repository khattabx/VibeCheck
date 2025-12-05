## Description
I have a very simple application that will be built with Kotlin in Android Studio. The app is a sentiment analysis tool.
The app will start with a splash screen, then move to the main screen. All screens should have fixed padding from all sides.

### Top Bar
At the top of the main screen, there will be a top bar with two icons: one on the left and one on the right.
- Pressing the first icon opens a page that shows the team members.
- Pressing the second icon opens a page that contains two images: the college logo and the university logo (one on the right and one on the left), and below them a line saying “Under the supervision of Dr. Marwa Elsedeek”.
#### Team Members
1. Ahmed Yasser Khattab
2. Mohamed Ebrahim Hamed
3. Eslam Mohamed Elgawessh
4. Mohamed Khalil
5. Mohamed Abouelenin
6. Hossam Youssef

### Main Screen
The main screen will contain two equal-sized boxes:
- The first box is for text analysis. It will have an icon in the center and a title below it
- The second box is for audio analysis. It will also have an icon in the center and a title below it.
### Text Analysis Screen
This screen has two parts:
1. A text box where the user enters the text.
2. A result section: three equal-sized horizontal boxes for the model output (Happy, Sad, Fear). All boxes are gray by default, and the one selected by the model becomes green.
### Audio Analysis Screen
This screen also has two parts:
1. A box for receiving audio input.
2. A result section identical to the text analysis screen: three gray boxes (Happy, Sad, Fear), and the detected result changes to green.
The app will be built in Kotlin using Android Studio.  
I need a prompt for each screen in the app. Any images needed will be stored in app/assets
Padding must be consistent across all screens.  
All boxes must have rounded corners with a fixed value (not fully circular).
### Color Palette
- Main Color: #3daf28 — 60%
- Secondary Color: #708D20 — 30%
- Accent Color: #F5FBF4 — 10%

Each prompt should be written separately under the name of its screen, and all prompts must be consistent with each other without conflicts.

---
## Time Line
- [x]  Git, GitHub
- [x] Assets/ .PNGs
- [x] Splash, Name, Icon
- [x] Top Bar
- [x] Main Screen
- [x] Text Analysis Screen
- [x] Audio Analysis Screen

--- 
## Screen Prompts 


Below are separate, consistent prompts you can use (for example with a UI/image generator) for each screen. They all share:

- Same padding on all sides  
- Same corner radius (rounded, not circular)  
- Same color palette and overall style  
- Assets located under `app/assets`

You can adjust wording slightly, but keep the structure and constraints.

---
## 1. Splash Screen Prompt

**Screen name: Splash Screen**
Design a mobile app **splash screen** for an Android sentiment analysis application built with Kotlin.

>**Layout & Style Requirements:**   - Platform: Android phone, portrait orientation.  
> - Use **consistent padding on all sides**; no elements should touch the edges of the screen.  
> - All boxes, panels, and containers must have **rounded corners with a fixed radius** (not fully circular).  
> - Color palette:  
>   - Main color: `#3DAF28` (60%)  
>   - Secondary color: `#708D20` (30%)  
>   - Accent color: `#F5FBF4` (10%)  
> - Overall style: clean, modern, flat UI, easy to implement in Android Studio with Kotlin.  
> - Background: primarily the **accent color** `#F5FBF4` with subtle use of the main and secondary colors for shapes or branding.  
>  
> **Content:**  
> - Centered app logo or icon in the middle of the screen (this logo will later be stored in `app/assets`). The logo should visually suggest sentiment analysis or emotions (for example, simple abstract face, chat bubble, or wave).  
> - Under the logo, include the **app name** in a clear, modern font. You may use a placeholder like “Sentiment Analyzer” or “EmotionSense”.  
> - Optionally, add a short tagline under the app name, such as:  
>   - “Text and Audio Sentiment Analysis”  
> - No navigation bars or buttons on this splash screen.  
>  
> **Consistency Constraints:**  
> - The same padding and corner radius used here will be reused for all other screens in the app.  
> - The visual style (colors, typography, and corner radius) must be easy to replicate on the following screens: Main Screen, Team Members Screen, Supervision Screen, Text Analysis Screen, and Audio Analysis Screen.  
> - The final exported asset should be compatible for use inside `app/assets` in an Android Studio Kotlin project.

---
## 2. Main Screen Prompt
**Screen name: Main Screen**
Design the **main screen** of a mobile sentiment analysis app for Android, developed in Kotlin.    
> **Layout & Style Requirements:**  
> - Platform: Android phone, portrait orientation.  
> - Use **consistent padding on all sides**; nothing should touch the edges.  
> - All boxes, cards, and containers must have **rounded corners with a fixed radius** (not circular).  
> - Color palette:  
>   - Main color: `#3DAF28` (60%)  
>   - Secondary color: `#708D20` (30%)  
>   - Accent color: `#F5FBF4` (10%)  
> - Overall style: modern, flat, minimal, easy to reproduce in Android Studio.  
> - Background: light, mostly **accent color** `#F5FBF4`, with the main and secondary colors used for important UI elements.  
>  
> **Top Bar:**  
> - A **top app bar** with the same left and right padding as the rest of the screen.  
> - Inside the top bar:  
>   - **Left icon**: a simple “team” or “group” icon (tappable) that will navigate to the Team Members screen.  
>   - **Right icon**: an “info” or “university/college” style icon (tappable) that will navigate to the Supervision/Logos screen.  
> - The top bar background can use the main color `#3DAF28` or secondary color `#708D20`, with icons in white or a high-contrast color.  
>  
> **Main Content:**  
> - Below the top bar, the main area should contain **two equal-sized rectangular boxes** (cards) arranged vertically or in a 2-row layout, both centered within the padded area.  
> - Both boxes must have the same **fixed corner radius** and share the same visual style.  
> - Each box has:  
>   1. A central icon  
>   2. A title text below the icon  
> - First box:  
>   - Represents **Text Analysis**.  
>   - Show a text-related icon (e.g., text bubble, document, or keyboard).  
>   - Title below the icon: “Text Analysis”.  
> - Second box:  
>   - Represents **Audio Analysis**.  
>   - Show an audio-related icon (e.g., microphone or sound wave).  
>   - Title below the icon: “Audio Analysis”.  
> - The two boxes should look clearly tappable (like buttons or cards) but remain simple and flat in design.  
>  
> **Consistency Constraints:**  
> - Padding and corner radius must exactly match what will be used on the Splash Screen, Team Members Screen, Supervision Screen, Text Analysis Screen, and Audio Analysis Screen.  
> - Keep all icons and imagery generic so they can be stored in `app/assets` and reused in an Android Studio Kotlin project.  

---

## 3. Team Members Screen Prompt
**Screen name: Team Members Screen**
Design a **Team Members screen** for a mobile sentiment analysis app built with Kotlin on Android.  

> **Layout & Style Requirements:**  
> - Platform: Android phone, portrait orientation.  
> - Use **consistent padding on all sides**; nothing touches the screen edges.  
> - All panels, list items, or boxes must have **rounded corners with the same fixed radius** used on other screens (not circular).  
> - Color palette:  
>   - Main color: `#3DAF28` (60%)  
>   - Secondary color: `#708D20` (30%)  
>   - Accent color: `#F5FBF4` (10%)  
> - Background: primarily `#F5FBF4` with main/secondary colors for text and accents.  
> - Overall style: clean and modern, consistent with the splash and main screens.  
>  
> **Top Bar:**  
> - Include a simple top app bar with the same padding and color style used on the main screen.  
> - The top bar can have a back arrow on the left to go back to the main screen, and a title such as “Team Members”.  
>  
> **Content:**  
> - Below the top bar, display a vertical list or stacked cards for the team members, all inside the padded area.  
> - Each team member can be a simple row or card with the shared fixed corner radius, light background, and subtle border or shadow.  
> - Show the following names in clear text (one name per row/card):  
>   1. Ahmed Yasser Khattab  
>   2. Mohamed Ebrahim Hamed  
>   3. Eslam Mohamed Elgawessh  
>   4. Mohamed Khalil  
>   5. Mohamed Abouelenin  
>   6. Hossam Youssef  
> - Use a simple, readable font. It is acceptable to have small avatar placeholders or icons next to each name, but keep them minimal.  
>  
> **Consistency Constraints:**  
> - The padding and corner radius must match the Splash Screen, Main Screen, Supervision Screen, Text Analysis Screen, and Audio Analysis Screen.  
> - The color palette and typography must align with the rest of the app so this screen can be easily implemented in Android Studio with assets under `app/assets`.  

---

## 4. Supervision / Logos Screen Prompt

**Screen name: Supervision Screen (Logos & Text)**
 Design a **Supervision and Logos screen** for a mobile sentiment analysis Android app built with Kotlin. This screen is opened by tapping the right icon on the main screen’s top bar.  
  
> **Layout & Style Requirements:**  
> - Platform: Android phone, portrait orientation.  
> - Use **consistent padding on all sides**; no element sits directly on the screen edges.  
> - All visible containers or image holders must use the same **fixed rounded corner radius** as on other screens (not circular).  
> - Color palette:  
>   - Main color: `#3DAF28` (60%)  
>   - Secondary color: `#708D20` (30%)  
>   - Accent color: `#F5FBF4` (10%)  
> - Background: primarily `#F5FBF4`.  
> - Overall style: clean, simple, and academic/professional.  
>  
> **Top Bar:**  
> - A top app bar similar to the main screen and team members screen, with a back arrow on the left and a title such as “About” or “Supervision”.  
>  
> **Main Content:**  
> - Within the padded area, show **two logos** horizontally aligned near the top or middle of the screen:  
>   - **Left side**: placeholder for the **university logo**.  
>   - **Right side**: placeholder for the **college logo**.  
> - Each logo is placed inside its own container or box using the shared fixed corner radius.  
> - Under these two logos, centered horizontally, place a clear text line that reads exactly:  
>   - **“Under the supervision of Dr. Marwa Elsedeek”**  
> - The text should be easily readable, neutral professional style, and can use the main or secondary color for emphasis.  
>  
> **Consistency Constraints:**  
> - Corner radius and padding must be identical to all other screens (Splash, Main, Team Members, Text Analysis, Audio Analysis).  
> - The logos themselves will be stored as image assets inside `app/assets`, so make sure they are inside simple, rectangular containers that are easy to implement in code.  

---
## 5. Text Analysis Screen Prompt
**Screen name: Text Analysis Screen**
 Design a **Text Analysis screen** for a mobile sentiment analysis app on Android, implemented with Kotlin. 
   
> **Layout & Style Requirements:**  
> - Platform: Android phone, portrait orientation.  
> - Use **consistent padding on all sides** so nothing touches the screen edges.  
> - All panels, input boxes, and result boxes must have **the same fixed rounded corner radius** as on other screens (not circular).  
> - Color palette:  
>   - Main color: `#3DAF28` (60%)  
>   - Secondary color: `#708D20` (30%)  
>   - Accent color: `#F5FBF4` (10%)  
> - Background: mostly `#F5FBF4` with main/secondary used for accents and active states.  
> - Overall style: clean, data-focused, easy to replicate in Android Studio.  
>  
> **Structure:**  
> The screen is divided vertically into **two main parts**:  
> 1. **Text Input Section**  
> 2. **Result Section**  
>  
> **Top Bar:**  
> - Include a top app bar with a back arrow to return to the main screen and a title like “Text Analysis”.  
> - Style is consistent with all other screens (same height, color scheme, and icon style).  
>  
> **1. Text Input Section:**  
> - Directly below the top bar, within the global padding, place a large **text input box** for the user to enter text.  
> - The text box:  
>   - Is a rectangular area with the app’s fixed corner radius.  
>   - Uses a light background (e.g., white or very light accent).  
>   - Inside, display a placeholder like “Enter your text here…”  
> - Optionally, below or attached to the text box, include a simple action button (e.g., “Analyze”) styled with the main color `#3DAF28`, also with the same corner radius.  
>  
> **2. Result Section:**  
> - Below the text input area, create a **horizontal row of three equal-sized rectangular result boxes**, all within the global padding.  
> - Each result box must:  
>   - Have the same fixed corner radius.  
>   - Be the same width and height.  
>   - By default, use a **neutral gray background**.  
> - Label the three boxes (from left to right):  
>   1. “Happy”  
>   2. “Sad”  
>   3. “Fear”  
> - Visual behavior concept (for design):  
>   - All three boxes start in gray.  
>   - When the model selects a sentiment, the corresponding box changes to **green**, using the main color `#3DAF28`, while the others remain gray.  
> - This change in color must be visually clear and can also include bold text for the active state.  
>  
> **Consistency Constraints:**  
> - Padding and corner radius must exactly match the Splash, Main, Team Members, Supervision, and Audio Analysis screens.  
> - All styles must be implementable in a Kotlin-based Android app, with any icons or decorative images stored under `app/assets`.  

---

## 6. Audio Analysis Screen Prompt
**Screen name: Audio Analysis Screen**
Design an **Audio Analysis screen** for a mobile sentiment analysis Android app developed with Kotlin.  
 
> **Layout & Style Requirements:**  
> - Platform: Android phone, portrait orientation.  
> - Use **consistent padding on all sides**; no element touches the screen edges.  
> - All boxes, audio panels, and result containers must have **the same fixed rounded corner radius** as on all other screens (not circular).  
> - Color palette:  
>   - Main color: `#3DAF28` (60%)  
>   - Secondary color: `#708D20` (30%)  
>   - Accent color: `#F5FBF4` (10%)  
> - Background: mostly `#F5FBF4`.  
> - Overall style: consistent with the Text Analysis screen, clean and modern.  
>  
> **Structure:**  
> The screen is divided vertically into **two main parts**:  
> 1. **Audio Input Section**  
> 2. **Result Section**  
>  
> **Top Bar:**  
> - Include a top app bar with a back arrow to return to the main screen and a title like “Audio Analysis”.  
> - Same style and padding as all other screens.  
>  
> **1. Audio Input Section:**  
> - Below the top bar, place a large **audio input box** inside the global padding.  
> - This box:  
>   - Is a rectangular card with the shared fixed corner radius.  
>   - Has a background that contrasts with the page (e.g., white or a light shade).  
>   - In the center, show an audio-related icon such as a **microphone** or **waveform**.  
>   - Optionally include label text like “Tap to record audio” or “Record Audio”.  
> - The box should look clearly tappable/interactive but remain simple.  
>  
> **2. Result Section:**  
> - Similar to the Text Analysis screen:  
>   - A **horizontal row of three equal-sized rectangular result boxes** inside the global padding.  
> - Each result box:  
>   - Has the same fixed corner radius.  
>   - Uses a **neutral gray background by default**.  
>   - Is equal in size and layout to the result boxes in the Text Analysis screen.  
> - Label the boxes from left to right:  
>   1. “Happy”  
>   2. “Sad”  
>   3. “Fear”  
> - Visual behavior concept:  
>   - Initially, all three boxes are gray.  
>   - Once the audio is analyzed, the detected sentiment’s box turns **green** using the main color `#3DAF28`, the others remain gray.  
>  
> **Consistency Constraints:**  
> - The layout and appearance of the result section must closely match the result section of the **Text Analysis screen** so they look like a pair.  
> - Padding and corner radius must match all other screens (Splash, Main, Team Members, Supervision, Text Analysis).  
> - All icons or images used (e.g., microphone icon) will be stored in `app/assets` and should be simple, flat-style assets suitable for Kotlin Android implementation.  

