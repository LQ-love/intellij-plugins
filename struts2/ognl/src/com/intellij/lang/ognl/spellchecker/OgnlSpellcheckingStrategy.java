/*
 * Copyright 2013 The authors
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.intellij.lang.ognl.spellchecker;

import com.intellij.lang.ognl.OgnlTypes;
import com.intellij.lang.ognl.psi.OgnlTokenGroups;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.spellchecker.tokenizer.SpellcheckingStrategy;
import com.intellij.spellchecker.tokenizer.Tokenizer;
import org.jetbrains.annotations.NotNull;

/**
 * Defines tokens to spell check.
 *
 * @author Yann C&eacute;bron
 */
public class OgnlSpellcheckingStrategy extends SpellcheckingStrategy {

  @NotNull
  @Override
  public Tokenizer getTokenizer(final PsiElement element) {
    final IElementType elementType = element.getNode().getElementType();
    if (elementType == OgnlTypes.IDENTIFIER ||
        OgnlTokenGroups.TEXT.contains(elementType)) {
      return TEXT_TOKENIZER;
    }

    return EMPTY_TOKENIZER;
  }
}
