// Text-to-speech utility for voice feedback
class VoiceManager {
  private synth: SpeechSynthesis;
  private enabled: boolean = true;

  constructor() {
    this.synth = window.speechSynthesis;
  }

  speak(text: string, lang: string = 'tr-TR'): void {
    if (!this.enabled) return;

    // Cancel any ongoing speech
    this.synth.cancel();

    const utterance = new SpeechSynthesisUtterance(text);
    utterance.lang = lang;
    utterance.rate = 0.9;
    utterance.pitch = 1.1;
    utterance.volume = 1.0;

    this.synth.speak(utterance);
  }

  speakEnglish(text: string): void {
    this.speak(text, 'en-US');
  }

  speakTurkish(text: string): void {
    this.speak(text, 'tr-TR');
  }

  toggle(): void {
    this.enabled = !this.enabled;
    if (!this.enabled) {
      this.synth.cancel();
    }
  }

  stop(): void {
    this.synth.cancel();
  }

  isEnabled(): boolean {
    return this.enabled;
  }
}

export const voiceManager = new VoiceManager();
