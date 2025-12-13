# Deployment Guide for Mete's Brain Game

## Quick Start for Users

### Option 1: Local Development (Easiest for Testing)
```bash
# 1. Install dependencies
npm install

# 2. Run the development server
npm run dev

# 3. Open http://localhost:5173 in your browser
```

### Option 2: Static Build (For Hosting)
```bash
# 1. Install dependencies
npm install

# 2. Build the production version
npm run build

# 3. The 'dist' folder contains all files ready to deploy
```

## Hosting Options

### 1. Vercel (Recommended - Free)
1. Push your code to GitHub
2. Go to https://vercel.com
3. Import your repository
4. Vercel will auto-detect Vite and deploy
5. Your app will be live at `your-project.vercel.app`

**Settings:**
- Build Command: `npm run build`
- Output Directory: `dist`
- Install Command: `npm install`

### 2. Netlify (Free)
1. Go to https://netlify.com
2. Drag and drop the `dist` folder after running `npm run build`
3. Or connect your GitHub repository for automatic deployments

**Settings:**
- Build Command: `npm run build`
- Publish Directory: `dist`

### 3. GitHub Pages (Free)
1. Install gh-pages:
   ```bash
   npm install --save-dev gh-pages
   ```

2. Add to `package.json`:
   ```json
   {
     "homepage": "https://yourusername.github.io/mete-",
     "scripts": {
       "predeploy": "npm run build",
       "deploy": "gh-pages -d dist"
     }
   }
   ```

3. Deploy:
   ```bash
   npm run deploy
   ```

### 4. Any Static Host
After running `npm run build`, upload the contents of the `dist` folder to any static hosting service:
- AWS S3 + CloudFront
- Google Cloud Storage
- Firebase Hosting
- Cloudflare Pages

## Server Configuration

### Important: SPA Routing
Since this is a Single Page Application, configure your server to redirect all routes to `index.html`:

**Netlify**: Create `public/_redirects`:
```
/*    /index.html   200
```

**Vercel**: Already handled automatically

**Apache**: Add to `.htaccess`:
```apache
<IfModule mod_rewrite.c>
  RewriteEngine On
  RewriteBase /
  RewriteRule ^index\.html$ - [L]
  RewriteCond %{REQUEST_FILENAME} !-f
  RewriteCond %{REQUEST_FILENAME} !-d
  RewriteRule . /index.html [L]
</IfModule>
```

**Nginx**: Add to config:
```nginx
location / {
  try_files $uri $uri/ /index.html;
}
```

## Environment Variables
This app doesn't require any environment variables.

## Browser Requirements
- Modern browsers (Chrome, Firefox, Safari, Edge)
- JavaScript enabled
- For voice features: Web Speech API support (most modern browsers)

## Performance Tips
1. Enable gzip compression on your server
2. Set proper cache headers for static assets
3. Use HTTPS for better performance and security
4. Consider CDN for faster global access

## Troubleshooting

### Voice not working?
- Check if browser supports Web Speech API
- Make sure browser has permission for speech synthesis
- Some browsers require HTTPS for speech API

### Build fails?
```bash
# Clear cache and reinstall
rm -rf node_modules package-lock.json
npm install
npm run build
```

### App not loading?
- Check browser console for errors
- Ensure all files from `dist` folder are uploaded
- Verify server configuration for SPA routing

## Testing Deployment
After deployment, test:
1. ✅ Welcome screen loads with animation
2. ✅ Voice greeting plays (might need user interaction first)
3. ✅ Category selection works
4. ✅ Games load and function correctly
5. ✅ Voice feedback works on questions
6. ✅ Results screen displays properly
7. ✅ Mobile responsive design works

## Support
For issues or questions, check:
- Browser console for errors
- Network tab for failed requests
- Ensure proper server configuration

---

**Ready to Deploy!** Choose your preferred hosting option and get started! 🚀
