/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.textarea;

import com.root101.swing.material.components.container.panel._PanelTransparent;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public abstract class ContentArea extends _PanelTransparent {

    public abstract ContentArea addText(String txt);

    public abstract ContentArea addHeader(String header);

    public abstract ContentArea header(String header);

    public abstract ContentArea text(String text);

    public abstract ContentArea textHorizontalAlignment(int textHorizontalAlignment);

    public abstract ContentArea headerFont(Font headerFont);

    public abstract ContentArea textFont(Font textFont);

    public abstract ContentArea backgroundColor(Color backColor);

}
